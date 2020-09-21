package com.adtec.pay.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统名称: 政融支付平台
 * 模块名称: 支付模型
 * 类名称 : SecretUtil
 * 功能说明: 系统通用加解密操作类 软件版权:
 * 北京先进数通信息技术股份公司
 * 开发人员: wanglzh@adtec.com.cn
 * 开发时间: 2019年6月27日17:13:29
 * 系统版本: V1.0
 * 修改记录:
 * 修改日期   人员  修改说明
 * ========= ===============================================<br>
 * 2019-6-27 王林柱 创建
 */
public class SecretUtil {

    // 加密
    public static String AESEncrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String AESDecrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);// 先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    /**
     * 生成密钥对
     *
     * @return
     */
    public static Map<String, String> generateKeyBytes() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Constants.KEY_ALGORITHM);
            keyPairGenerator.initialize(Constants.KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            Map<String, String> keyMap = new HashMap();
            keyMap.put(Constants.PUBLIC_KEY_WORDS, Base64.encodeBase64String(publicKey.getEncoded()));
            keyMap.put(Constants.PRIVATE_KEY_WORDS, Base64.encodeBase64String(privateKey.getEncoded()));
            return keyMap;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("签名验证失败");

        }
        return null;
    }

    /**
     * 还原公钥
     *
     * @param publicKey
     * @return
     */
    public static PublicKey restorePublicKey(String publicKey) {
        byte[] prikeyByte;
        PublicKey pubTypeKey = null;
        try {
            prikeyByte = Base64.decodeBase64(publicKey.getBytes("UTF-8"));
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(prikeyByte);
            KeyFactory factory = KeyFactory.getInstance(Constants.KEY_ALGORITHM);

            pubTypeKey = factory.generatePublic(x509EncodedKeySpec);
            return pubTypeKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("签名算法失败，不支持的编码");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            System.out.println("签名算法失败，不支持的签名算法");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("签名算法失败，不支持的密钥");
        }
        return null;
    }

    /**
     * 还原私钥
     *
     * @param privateKey
     * @return
     */
    public static PrivateKey restorePrivateKey(String privateKey) {
        byte[] prikeyByte;
        PrivateKey priTypeKey = null;
        try {
            prikeyByte = Base64.decodeBase64(privateKey.getBytes("UTF-8"));
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(prikeyByte);
            KeyFactory factory = KeyFactory.getInstance(Constants.KEY_ALGORITHM);
            priTypeKey = factory.generatePrivate(pkcs8EncodedKeySpec);
            return priTypeKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("签名算法失败，不支持的编码");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            System.out.println("签名算法失败，不支持的签名算法");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("签名算法失败，不支持的密钥");
        }
        return null;
    }

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param plain_text 明文
     * @return
     */
    public static String sign(String privateKey, String plain_text) {
        return Base64.encodeBase64String(sign(restorePrivateKey(privateKey), plain_text));
    }

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param plain_text 明文
     * @return
     */
    public static byte[] sign(PrivateKey privateKey, String plain_text) {
        byte[] signed = null;
        try {
            Signature Sign = Signature.getInstance(Constants.SIGNATURE_ALGORITHM);
            Sign.initSign(privateKey);
            Sign.update(plain_text.getBytes());
            signed = Sign.sign();
            // System.out.println("SHA256withRSA签名后-----》" +
            // bytesToHexString(signed));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return signed;
    }

    /**
     * 验签
     *
     * @param publicKey 公钥
     * @param srcMsg    明文
     * @param signed    签名
     */
    public static boolean verifySign(String publicKey, String srcMsg, String signed) {
        PublicKey publicTypeKey = restorePublicKey(publicKey);
        return verifySign(publicTypeKey, srcMsg.replace("+", "%2B"), signed);

    }

    /**
     * 验签
     *
     * @param publicKey  公钥
     * @param plain_text 明文
     * @param signed     签名
     */
    private static boolean verifySign(PublicKey publicKey, String plain_text, String signed) {
        // MessageDigest messageDigest;
        boolean SignedSuccess = false;
        try {
            // messageDigest = MessageDigest.getInstance(ENCODE_ALGORITHM);
            // messageDigest.update(plain_text.getBytes("UTF-8"));
            // byte[] outputDigest_verify = messageDigest.digest();
            // System.out.println("SHA-256加密后-----》" + bytesToHexString(outputDigest_verify));
            Signature verifySign = Signature.getInstance(Constants.SIGNATURE_ALGORITHM);
            verifySign.initVerify(publicKey);
            verifySign.update(plain_text.getBytes("UTF-8"));
            SignedSuccess = verifySign.verify(Base64.decodeBase64(signed.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SignedSuccess;
    }

    /**
     * bytes[]换成16进制字符串
     *
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 十六进制的字符串转换为字节数组
     *
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];

        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (chartobyte(hexChars[pos]));
        }
        return d;
    }

    /**
     * 以16进制打印字节数组
     *
     * @param b
     */

    private static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();

    }

    private static byte chartobyte(char c) {
        return (byte) "123456789abcdef".indexOf(c);
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         *
         * String cKey = "1234567890123456"; // 需要加密的字串 String cSrc =
         * "www.gowhere.so"; System.out.println(cSrc); // 加密 String enString =
         * SecretUtil.AESEncrypt(cSrc, cKey); System.out.println("加密后的字串是：" +
         * enString);
         *
         * // 解密 String DeString = SecretUtil.AESDecrypt(enString, cKey);
         * System.out.println("解密后的字串是：" + DeString);
         */

        /*
         * 此处使用RSA加密模式，key需要为16位。
         *
         */
        // 公私钥对
        Map<String, String> keyMap = SecretUtil.generateKeyBytes();
        String pubkey = keyMap.get(Constants.PUBLIC_KEY_WORDS);
        String prikey = keyMap.get(Constants.PRIVATE_KEY_WORDS);
        System.out.println("公钥 = " + pubkey);
        System.out.println("私钥 = " + prikey);

        // RSA加签
        String sign = SecretUtil.sign(prikey, Constants.PLAIN_TEXT);
        System.out.println("sign:" + sign);
        // RSA验签
        boolean flag = SecretUtil.verifySign(pubkey, Constants.PLAIN_TEXT, sign);
        System.out.println(flag);
        prikey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDHA4aY7zuJm06HXrj07RGIlaYNu2Ft1WvPr6RoYDikAQlp9YepEw98fryt8jzKqNlhvcRyIKuRctHOmPAKTe92YYr4zZHtJHHuE+EBse+LIR906waGqQZwdwo/r6L2GDjhzND6IXyYtvarGOEtIbGg7+JxsnoWfN6ox4GMoySD5rvhmKERZ1Ps44zs0FetUnVVm9tp8JBwxS5Siak0q78vyBF+ZcgaiAALfmwEnJGBBRseek8+g8htTtY3bP7MwAynRHv9+zT+zrKh1IIzEBUjq1IPoiCHksfPjQbLMb35FSaNi6LXP+D+Xb+JsfRWSOPUvqZd41KnrWMV3C9kDqI9AgMBAAECggEAQ8Z4nTbD8O4aRVHF7WubEAfe4EhTOuN27ujjNcSnJXtQ6Gv8wmDCYmSK/zZC68WrGnVVJITpyQPwXcqJ3QiDp646dNcVfkxuHGVauIgPizNBkkDEHTINBloT/HJlLig7nvJwrO6gjyWoRcaYURVrd+KaHJxqpaPq9FHVVb7tnZlpbjWdVPSmsQb7LdQzcXtIVe/jcll5zJy1HPy+EXPZKmf8Nf+bJCtVl8BORkviFw8Y27aN3ERNlML7dIHzztdN+nzMtsD3/HU+ivZUtkg3ClKc0kjxRwuoGdfIF48RKQ9pxku9EZNwsS0N49GuN8J9FFAFtmhhoB5rEGD0RscrgQKBgQDzfgAYpsZQ3xQHaLKDHyhScg2CaKqw0Vd+nRlh/xM0pKrExxsxVUU5HiN892OD83cal3U6e0Q/mAb7uCd+PUjb7IJC1MTYrHrZ3tqlzKTLFhC5rRb8bIGqjibkQu5fgn7SSQEg2tis2GSqtByK0tvco5yqp89hE8I0AVfGlG5l4QKBgQDRPJ6+UbdZIP4HvNrAFb5jhSS9ESMMeypzvEDiHyCC8oPkZWW2yTlZ9fKLanj4mQuoSl97P+cdGB8k0UQlJYEFskAdwLB/Jrc8FBIZ051jAXvpRdwRNvZ3ubia89DjwVS47qW+tGw5eY7hI+fzQIwi/2LPyZlONzSuj4KloNiP3QKBgQCy5bV+ZzI4At69XtAhhIfko0WHtg0LIpPtQ9F9baKXwBBzyXISOftFLv6V91FXhk7Q68zGrgCD1Nf0o+XoW3CnnMpL/fWu2HLell0BCi1dxRV+xkyoI7TVMeIjPYXUCJXTPK4mjIQ74jV8Mh7yZGADaPZXcDnuskyyVvY9wZqnIQKBgQCHQ1ggEvWjcdenKuiDassUzRrt+ukchXbxMM8FHzhGTv8CpKY3nygrRvsQM7mWhGHr3oCRTcNbpJ9ljr8uAGvDQfN/CHVRDbdA6Hy3I31IZsozCI12t4Bn77EuwtXUlsPtdaHCgiLAmRvL4glt0NmHOnAngd1QmhG9k1rTNgMqJQKBgCkOnef5MXD/0z/bFTnOQyyE+aMXaFaRqmAig9u2mUHm7keclUF2atU8q3ateCv3t6FMYpnE5we99qSzy36Loji263qS0Wq4G9mx1CQB5uChv82Sb07pQCt8I9ixqV6ZunUSsaC/ONDiNW7Q2TAfZ7yM5IPgG2yMzT3Ozp4eFtVR";

        // RSA加签
        sign = SecretUtil.sign(prikey, "Rfnd_Acpt_Tm=20190312&Rfnd_Amt=10.0&Rfnd_StCd=4&Rfnd_TrcNo=23411");
        System.out.println("sign:" + sign);
        pubkey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxwOGmO87iZtOh1649O0RiJWmDbthbdVrz6+kaGA4pAEJafWHqRMPfH68rfI8yqjZYb3EciCrkXLRzpjwCk3vdmGK+M2R7SRx7hPhAbHviyEfdOsGhqkGcHcKP6+i9hg44czQ+iF8mLb2qxjhLSGxoO/icbJ6FnzeqMeBjKMkg+a74ZihEWdT7OOM7NBXrVJ1VZvbafCQcMUuUompNKu/L8gRfmXIGogAC35sBJyRgQUbHnpPPoPIbU7WN2z+zMAMp0R7/fs0/s6yodSCMxAVI6tSD6Igh5LHz40GyzG9+RUmjYui1z/g/l2/ibH0Vkjj1L6mXeNSp61jFdwvZA6iPQIDAQAB";

        // RSA验签
        String a = "Ys3cySTTgYYj/jjIKSyNVhDtnc2/fyz4TTezi2RlhMVZsRX8sxD2DvoTiev2DB7XAvvX+p0Jzty3eDTjhj6bJPTeQNA1anCRdotwg91qvrh+s7ddsKoX+05ELRR1vtZEDGsfOMWjn/DXl12JoJnc60Ce9k1N9vhTLBinIjasFvE5HMn8sichrpuewXOra6hXhyU42cMcUpbty/hoEYC7ohUjK0PtFz5USpCneVvNBBy/SLZE/ivJ9yEv642qQPZJ6snJwsc5MuZdydawu/dw2Wz1t8KxIOZyoOAQrIXhPr72q8iKD1BQZVKKlXRUDIYzJI3fmeCzj1Wb6668LpwnBA==";
        flag = SecretUtil.verifySign(Constants.APP_PUBLIC_KEY, "a=201911150018", a);
        System.out.println(flag);

    }

}
