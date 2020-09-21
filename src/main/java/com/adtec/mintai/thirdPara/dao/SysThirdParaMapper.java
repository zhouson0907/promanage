package com.adtec.mintai.thirdPara.dao;

import com.adtec.mintai.thirdPara.entity.SysThirdPara;
import com.adtec.mintai.thirdPara.entity.SysThirdParaExample;
import com.adtec.mintai.thirdPara.entity.SysThirdParaVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysThirdParaMapper {
    long countByExample(SysThirdParaExample example);

    int deleteByExample(SysThirdParaExample example);

    @Insert({
            "insert into t_sys_third_para (SYS_CODE, SYS_NAME, ",
            "STAT, BUSI_NO, SYS_NO, ",
            "FILE_BATH_PATH, FTP_SERVER, ",
            "FTP_USER, FTP_PASSWD, ",
            "FTP_PORT, ENCRYP_ALG, ",
            "SYS_PUBLIC_KEY, SYS_PRIVATE_KEY, ",
            "CREATE_TIME, CREATE_USER, ",
            "UPDATE_TIME, UPDATE_USER, ",
            "REMARK1, REMARK2, ",
            "REMARK3)",
            "values (#{sysCode,jdbcType=VARCHAR}, #{sysName,jdbcType=VARCHAR}, ",
            "#{stat,jdbcType=VARCHAR}, #{busiNo,jdbcType=VARCHAR}, #{sysNo,jdbcType=VARCHAR}, ",
            "#{fileBathPath,jdbcType=VARCHAR}, #{ftpServer,jdbcType=VARCHAR}, ",
            "#{ftpUser,jdbcType=VARCHAR}, #{ftpPasswd,jdbcType=VARCHAR}, ",
            "#{ftpPort,jdbcType=VARCHAR}, #{encrypAlg,jdbcType=VARCHAR}, ",
            "#{sysPublicKey,jdbcType=VARCHAR}, #{sysPrivateKey,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=VARCHAR}, #{createUser,jdbcType=VARCHAR}, ",
            "#{updateTime,jdbcType=VARCHAR}, #{updateUser,jdbcType=VARCHAR}, ",
            "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
            "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(SysThirdPara record);

    int insertSelective(SysThirdPara record);

    @Update({
            "update t_sys_third_para ",
            "set FTP_SERVER=#{ftpServer,jdbcType=VARCHAR}, ",
            "FTP_USER = #{ftpUser,jdbcType=VARCHAR}, ",
            "FTP_PASSWD = #{ftpPasswd,jdbcType=VARCHAR}, ",
            "FTP_PORT = #{ftpPort,jdbcType=VARCHAR}, ",
            "SYS_PUBLIC_KEY=#{sysPublicKey,jdbcType=VARCHAR}, ",
            "SYS_PRIVATE_KEY=#{sysPrivateKey,jdbcType=VARCHAR}",
            "where SYS_CODE = #{sysCode, jdbcType=VARCHAR}"
    })
    int updateThirdParaBySysCode(SysThirdPara sysThirdPara);

    List<SysThirdParaVo> selectByExample(SysThirdParaExample example);

    int updateByExampleSelective(@Param("record") SysThirdPara record, @Param("example") SysThirdParaExample example);

    int updateByExample(@Param("record") SysThirdPara record, @Param("example") SysThirdParaExample example);
}