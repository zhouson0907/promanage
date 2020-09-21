package com.adtec.base.system.service.impl;

import com.adtec.base.system.entity.Code;
import com.adtec.base.system.entity.CodeExample;
import com.adtec.base.system.dao.CodeMapper;
import com.adtec.base.system.service.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @version V1.0
 * @Description: Code实现类
 * @author: 胡浪
 * @date: 2018/8/28
 * @Copyright: 北京先进数通信息技术股份公司 http://www.adtec.com.cn
 */
@Service
public class CodeServiceImpl implements CodeService {

    private Logger logger = LoggerFactory.getLogger(CodeServiceImpl.class);

    @Autowired
    private CodeMapper codeMapper;

    /**
     * 增
     */
    @Override
    public void saveCode(Code code) throws Exception {
        logger.error("saveDailyDetail-start");
        try {
            codeMapper.insertSelective(code);
            logger.error("saveDailyDetail-end");
        } catch (Exception e) {
            logger.error("saveDailyDetail-error");
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }

    }

    /**
     * 删
     */
    @Override
    public void deleteCode(Code code) throws Exception {
        logger.error("deleteCode-start");
        try {
            codeMapper.deleteByPrimaryKey(code.getId());
            logger.error("deleteCode-end");
        } catch (Exception e) {
            logger.error("deleteCode-error");
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    /**
     * 改
     */
    @Override
    public void updateCode(Code code, CodeExample example) throws Exception {
        logger.error("updateCode-start");
        try {
            codeMapper.updateByExampleSelective(code, example);
            logger.error("updateCode-end");
        } catch (Exception e) {
            logger.error("updateCode-error");
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    /**
     * 查
     */
    @Override
    public List<Code> queryCodeList(CodeExample example) throws Exception{
        logger.error("queryCodeList-start");
        try {
            List<Code> codeList = codeMapper.selectByExample(example);
            logger.error("queryCodeList-end");
            return codeList;
        } catch (Exception e) {
            logger.error("queryCodeList-error");
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }


}
