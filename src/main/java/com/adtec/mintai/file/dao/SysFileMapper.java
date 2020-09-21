package com.adtec.mintai.file.dao;

import com.adtec.mintai.file.entity.SysFile;
import com.adtec.mintai.file.entity.SysFileExample;
import com.adtec.mintai.file.entity.SysFileVo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SysFileMapper {
    long countByExample(SysFileExample example);

    int deleteByExample(SysFileExample example);

    @Delete({
            "delete from t_sys_file",
            "where id = #{id,jdbcType=INTEGER}",
            "and demand_id = #{demandId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(SysFileVo record);

    @Insert({
            "insert into t_sys_file (SYS_CODE, PLAT_DATE, ",
            "FILE_SER, FILE_NM, ",
            "FILE_TYPE, STAT, ",
            "FILE_PATH, CRT_TIME, ",
            "UPT_TIME)",
            "values (#{sysCode,jdbcType=VARCHAR}, #{platDate,jdbcType=VARCHAR}, ",
            "#{fileSer,jdbcType=VARCHAR}, #{fileNm,jdbcType=VARCHAR}, ",
            "#{fileType,jdbcType=VARCHAR}, #{stat,jdbcType=VARCHAR}, ",
            "#{filePath,jdbcType=VARCHAR}, #{crtTime,jdbcType=VARCHAR}, ",
            "#{uptTime,jdbcType=VARCHAR})"
    })
    int insert(SysFileVo record);

    int insertSelective(SysFileVo record);

    @Select({
            "select",
            "id, project_id, demand_id, demand_departmant, demand_maker, demand_date, demand_auditor, ",
            "demand_system, demand_module, demand_progress, version_num, demand_respo_id, ",
            "demand_name, demand_des, demand_stat, lead_date, planned_finish_date, actual_finish_date, ",
            "planned_online_date, actual_online_date, priority, workload, workload_confirm, ",
            "settlement_situation, create_time, create_user_id, update_time, update_user_id, ",
            "remark1, remark2, remark3",
            "from t_sys_file",
            "where id = #{id,jdbcType=INTEGER} and demand_id = #{demandId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.adtec.mintai.file.dao.SysFileMapper.BaseResultMap")
    SysFileVo selectByPrimaryKey(SysFileVo record);

    List<SysFileVo> selectByExample(SysFileExample example);

    int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example);

    @Update({
            "update t_sys_file",
            "set project_id = #{projectId,jdbcType=VARCHAR},",
            "demand_id = #{demandId,jdbcType=VARCHAR},",
            "demand_departmant = #{demandDepartmant,jdbcType=VARCHAR},",
            "demand_maker = #{demandMaker,jdbcType=VARCHAR},",
            "demand_date = #{demandDate,jdbcType=DATE},",
            "demand_auditor = #{demandAuditor,jdbcType=VARCHAR},",
            "demand_system = #{demandSystem,jdbcType=VARCHAR},",
            "demand_module = #{demandModule,jdbcType=VARCHAR},",
            "demand_progress = #{demandProgress,jdbcType=VARCHAR},",
            "version_num = #{versionNum,jdbcType=VARCHAR},",
            "demand_respo_id = #{demandRespoId,jdbcType=VARCHAR},",
            "demand_name = #{demandName,jdbcType=VARCHAR},",
            "demand_des = #{demandDes,jdbcType=VARCHAR},",
            "demand_stat = #{demandStat,jdbcType=VARCHAR},",
            "lead_date = #{leadDate,jdbcType=DATE},",
            "planned_finish_date = #{plannedFinishDate,jdbcType=DATE},",
            "actual_finish_date = #{actualFinishDate,jdbcType=DATE},",
            "planned_online_date = #{plannedOnlineDate,jdbcType=DATE},",
            "actual_online_date = #{actualOnlineDate,jdbcType=DATE},",
            "priority = #{priority,jdbcType=VARCHAR},",
            "workload = #{workload,jdbcType=VARCHAR},",
            "workload_confirm = #{workloadConfirm,jdbcType=VARCHAR},",
            "settlement_situation = #{settlementSituation,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_user_id = #{createUserId,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "remark1 = #{remark1,jdbcType=VARCHAR},",
            "remark2 = #{remark2,jdbcType=VARCHAR},",
            "remark3 = #{remark3,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysFileVo record);
}