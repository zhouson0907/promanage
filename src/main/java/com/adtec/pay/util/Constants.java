package com.adtec.pay.util;

public class Constants {

    // -----------------------------时间类变量-------------------------------------

    public static final String F_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String F_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String F_HH_MM_SS = "HH:mm:ss";
    public static final String F_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String F_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String F_YYYYMMDD = "yyyyMMdd";


    // -----------------------------加密类变量-------------------------------------
    public static final String KEY_ALGORITHM = "RSA";
    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final String PUBLIC_KEY_WORDS = "publicKey";
    public static final String PRIVATE_KEY_WORDS = "privateKey";

    public static final int KEY_SIZE = 2048;
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    public static final String ENCODE_ALGORITHM = "SHA-256";
    public static final String PLAIN_TEXT = "test string test stringtest stringtest stringtest stringtest stringtest stringtest string";


    // -----------------------------支付宝加密类变量-------------------------------------
    public static final String APP_ID = "2016090900468072";
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7+vDiHOZ8BgryvRQozfno8qofvfRnjJBfHBR2TDJ/1SAE21oqzEqDGGCmCKVWPAPncu9J4CO6XCoTtyPaYOzAyEZvZE+2uAOW2HoxNg/K658GT4uA6nPdJORBbjQd70KIkEvoYhYkOUesGYfJqEVNBmSQN7Zc/sTqekMCCEMpmURsRFZDsx3zHxqJ5IbcIt7gK5PVyq9zMlW08RTcVUV+h8EyttLbFQUPn7p1iAg/EJH5DpkJmGHASk62xFWj0XU8iUkFmdyphLpPUW+CqRLJuD0eUiH+g+hRTeHa5/m8oyPq1HE/DWRF0hwt4JYON082H3JJ17rEzapVERFLDN/qwIDAQAB";
    public static final String APP_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqQjd27EL+47vTcmXOzkFeh+18Vk88NtRRbOc2LzyFcE6JLK9T6rehs9YvhIRqpThcmlAAQzD+jr7GodmXX2XgC3kALEEwM+Wj+WaHjNfwIvqhzMgepyT89qjyXf1Bs57ZIPMeIU5g9WaonsQjmJNuRC4kp9RezLfkvyj3yTvVgAfX+Zo2eDijs3MPwKF/f0O7Y8hswL1W528ciVjhLPyN38lKIj8XjY/dmsXUTI1LvbL/4hNc8znfnVd/WV+RjLgKWfDDyFbbbeyWyA2ay1ftQ8OrXqcSJAXv/olWD5oDtvry1GVHvvorzcT99vG7pcLPTlD22Y4oMrAdv4fvm89qwIDAQAB";
    public static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCpCN3bsQv7ju9NyZc7OQV6H7XxWTzw21FFs5zYvPIVwToksr1Pqt6Gz1i+EhGqlOFyaUABDMP6Ovsah2ZdfZeALeQAsQTAz5aP5ZoeM1/Ai+qHMyB6nJPz2qPJd/UGzntkg8x4hTmD1ZqiexCOYk25ELiSn1F7Mt+S/KPfJO9WAB9f5mjZ4OKOzcw/AoX9/Q7tjyGzAvVbnbxyJWOEs/I3fyUoiPxeNj92axdRMjUu9sv/iE1zzOd+dV39ZX5GMuApZ8MPIVttt7JbIDZrLV+1Dw6tepxIkBe/+iVYPmgO2+vLUZUe++ivNxP328bulws9OUPbZjigysB2/h++bz2rAgMBAAECggEAJd5ApakCQDcDUW/qG3Bo07Uq84jEaEkZ6f2VE9EwgsMpHXOVibWD6Lum693sa0SzRQhjOFj9xp9UBdtziVpLiIG/ZJBDulZHKrGLV1y3BNHTlrpTemR9mNHQg6AGGqJDbn9AXXerLOe7ns7nJJ7NPrqKPv7GKE17XNiQdbs2ixNaYPVXwnGSlXepMmqEWZLQJyF8H+PmVVh+Ei3YeXNM40sMciglHxdmwL52pbtLk/hMulcahRz1/u5bKUhUNzRp01AhSjZkTgYGsPILd/q/N9aK3evk7eAc5M2HJQ4drowsOXzo8gnrkEL8zc8XysQQUKAj46CkjwgI536z6Ofx8QKBgQDjXTt448zPZ+MvG2RPuGw+xsIDs+18Zp/UVJaWlRia15O4kv+pd7aXWnshRlWpNHr1RF7vVhjmqewsP878WVtk6zJr1j6doRMMTOv+YHp2tkMAVj4qENbN2AsQYVcY6OPx9rFeFvYYOFCUuVDhSrfwAEZN6VByGA96qP9Aoys+lQKBgQC+UvMKm4+Kd9ETUjZ8yFpG7cGEf3wHbMPRrj7uSVaIHcRw7BR6bKUCCwmsP5/zP8cd3DBcrrZszDrnVCRX4HxgSo3WQdqAoCPREkVwU2eQenWqCfre63BtJXEfc3JVYQK0BX9bfdedcU+ngiClprvL5A0AaVcWtkPM1vb3PsS7PwKBgQDL6X0CMgQo67pkMEPp/7QNJUMyAPf4Py4PR4H7MWLs1HUm76edvMEkw0B1GliPNYMlX5lpO6V/klw/X0brKdT/ELWa434q7yBfQsnQzYRn3ZT/w1ljbtDHsoBRw4tSyuRMyPxQL3WtSSx0BjQUqmeHNyfWjm7YtN2FG/Y5aV3KdQKBgBAqvah2BGBvwxvQDP7WigyiX6Dgr2l2DMA/++qD4kzXsnshIrAvkGi3BVBTa0PfdAuOS7Fjye09//bsh9XLJOWND7VWjLgGYmR9F9btzstQC7Sw+lV7TGaJGq3gQaMNBYzDNslPzEP8fxaskBdiLWupaI1TZWlxfBrnW70u4MlDAoGASvIjz9B6Wz1IKE5QpXsQnZaZlOh1sbZ88ATi23NK8YCxeHOUa16Fn7r/4f+O+2shywLLnjUEckd4+uEcRwapegShiHv950PNZq8DFPF0wwPUJU+kcaGDj3AR141r5UpBoiaix3XM20ale0TWfbYwSFRiODhjwstzcS7NDQzTLUA=";
    public static final String CHARSET = "UTF-8";

}
