package com.adtec.mintai.thirdPara.entity;

import java.util.ArrayList;
import java.util.List;

public class SysThirdParaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysThirdParaExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSysCodeIsNull() {
            addCriterion("SYS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSysCodeIsNotNull() {
            addCriterion("SYS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSysCodeEqualTo(String value) {
            addCriterion("SYS_CODE =", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotEqualTo(String value) {
            addCriterion("SYS_CODE <>", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThan(String value) {
            addCriterion("SYS_CODE >", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_CODE >=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThan(String value) {
            addCriterion("SYS_CODE <", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThanOrEqualTo(String value) {
            addCriterion("SYS_CODE <=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLike(String value) {
            addCriterion("SYS_CODE like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotLike(String value) {
            addCriterion("SYS_CODE not like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeIn(List<String> values) {
            addCriterion("SYS_CODE in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotIn(List<String> values) {
            addCriterion("SYS_CODE not in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeBetween(String value1, String value2) {
            addCriterion("SYS_CODE between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotBetween(String value1, String value2) {
            addCriterion("SYS_CODE not between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNull() {
            addCriterion("SYS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNotNull() {
            addCriterion("SYS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSysNameEqualTo(String value) {
            addCriterion("SYS_NAME =", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotEqualTo(String value) {
            addCriterion("SYS_NAME <>", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThan(String value) {
            addCriterion("SYS_NAME >", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_NAME >=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThan(String value) {
            addCriterion("SYS_NAME <", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThanOrEqualTo(String value) {
            addCriterion("SYS_NAME <=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLike(String value) {
            addCriterion("SYS_NAME like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotLike(String value) {
            addCriterion("SYS_NAME not like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameIn(List<String> values) {
            addCriterion("SYS_NAME in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotIn(List<String> values) {
            addCriterion("SYS_NAME not in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameBetween(String value1, String value2) {
            addCriterion("SYS_NAME between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotBetween(String value1, String value2) {
            addCriterion("SYS_NAME not between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andBusiNoIsNull() {
            addCriterion("BUSI_NO is null");
            return (Criteria) this;
        }

        public Criteria andBusiNoIsNotNull() {
            addCriterion("BUSI_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBusiNoEqualTo(String value) {
            addCriterion("BUSI_NO =", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotEqualTo(String value) {
            addCriterion("BUSI_NO <>", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoGreaterThan(String value) {
            addCriterion("BUSI_NO >", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_NO >=", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoLessThan(String value) {
            addCriterion("BUSI_NO <", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoLessThanOrEqualTo(String value) {
            addCriterion("BUSI_NO <=", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoLike(String value) {
            addCriterion("BUSI_NO like", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotLike(String value) {
            addCriterion("BUSI_NO not like", value, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoIn(List<String> values) {
            addCriterion("BUSI_NO in", values, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotIn(List<String> values) {
            addCriterion("BUSI_NO not in", values, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoBetween(String value1, String value2) {
            addCriterion("BUSI_NO between", value1, value2, "busiNo");
            return (Criteria) this;
        }

        public Criteria andBusiNoNotBetween(String value1, String value2) {
            addCriterion("BUSI_NO not between", value1, value2, "busiNo");
            return (Criteria) this;
        }

        public Criteria andSysNoIsNull() {
            addCriterion("SYS_NO is null");
            return (Criteria) this;
        }

        public Criteria andSysNoIsNotNull() {
            addCriterion("SYS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSysNoEqualTo(String value) {
            addCriterion("SYS_NO =", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoNotEqualTo(String value) {
            addCriterion("SYS_NO <>", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoGreaterThan(String value) {
            addCriterion("SYS_NO >", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_NO >=", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoLessThan(String value) {
            addCriterion("SYS_NO <", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoLessThanOrEqualTo(String value) {
            addCriterion("SYS_NO <=", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoLike(String value) {
            addCriterion("SYS_NO like", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoNotLike(String value) {
            addCriterion("SYS_NO not like", value, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoIn(List<String> values) {
            addCriterion("SYS_NO in", values, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoNotIn(List<String> values) {
            addCriterion("SYS_NO not in", values, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoBetween(String value1, String value2) {
            addCriterion("SYS_NO between", value1, value2, "sysNo");
            return (Criteria) this;
        }

        public Criteria andSysNoNotBetween(String value1, String value2) {
            addCriterion("SYS_NO not between", value1, value2, "sysNo");
            return (Criteria) this;
        }

        public Criteria andFileBathPathIsNull() {
            addCriterion("FILE_BATH_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFileBathPathIsNotNull() {
            addCriterion("FILE_BATH_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFileBathPathEqualTo(String value) {
            addCriterion("FILE_BATH_PATH =", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathNotEqualTo(String value) {
            addCriterion("FILE_BATH_PATH <>", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathGreaterThan(String value) {
            addCriterion("FILE_BATH_PATH >", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_BATH_PATH >=", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathLessThan(String value) {
            addCriterion("FILE_BATH_PATH <", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathLessThanOrEqualTo(String value) {
            addCriterion("FILE_BATH_PATH <=", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathLike(String value) {
            addCriterion("FILE_BATH_PATH like", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathNotLike(String value) {
            addCriterion("FILE_BATH_PATH not like", value, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathIn(List<String> values) {
            addCriterion("FILE_BATH_PATH in", values, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathNotIn(List<String> values) {
            addCriterion("FILE_BATH_PATH not in", values, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathBetween(String value1, String value2) {
            addCriterion("FILE_BATH_PATH between", value1, value2, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFileBathPathNotBetween(String value1, String value2) {
            addCriterion("FILE_BATH_PATH not between", value1, value2, "fileBathPath");
            return (Criteria) this;
        }

        public Criteria andFtpServerIsNull() {
            addCriterion("FTP_SERVER is null");
            return (Criteria) this;
        }

        public Criteria andFtpServerIsNotNull() {
            addCriterion("FTP_SERVER is not null");
            return (Criteria) this;
        }

        public Criteria andFtpServerEqualTo(String value) {
            addCriterion("FTP_SERVER =", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerNotEqualTo(String value) {
            addCriterion("FTP_SERVER <>", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerGreaterThan(String value) {
            addCriterion("FTP_SERVER >", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerGreaterThanOrEqualTo(String value) {
            addCriterion("FTP_SERVER >=", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerLessThan(String value) {
            addCriterion("FTP_SERVER <", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerLessThanOrEqualTo(String value) {
            addCriterion("FTP_SERVER <=", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerLike(String value) {
            addCriterion("FTP_SERVER like", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerNotLike(String value) {
            addCriterion("FTP_SERVER not like", value, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerIn(List<String> values) {
            addCriterion("FTP_SERVER in", values, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerNotIn(List<String> values) {
            addCriterion("FTP_SERVER not in", values, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerBetween(String value1, String value2) {
            addCriterion("FTP_SERVER between", value1, value2, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpServerNotBetween(String value1, String value2) {
            addCriterion("FTP_SERVER not between", value1, value2, "ftpServer");
            return (Criteria) this;
        }

        public Criteria andFtpUserIsNull() {
            addCriterion("FTP_USER is null");
            return (Criteria) this;
        }

        public Criteria andFtpUserIsNotNull() {
            addCriterion("FTP_USER is not null");
            return (Criteria) this;
        }

        public Criteria andFtpUserEqualTo(String value) {
            addCriterion("FTP_USER =", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserNotEqualTo(String value) {
            addCriterion("FTP_USER <>", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserGreaterThan(String value) {
            addCriterion("FTP_USER >", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserGreaterThanOrEqualTo(String value) {
            addCriterion("FTP_USER >=", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserLessThan(String value) {
            addCriterion("FTP_USER <", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserLessThanOrEqualTo(String value) {
            addCriterion("FTP_USER <=", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserLike(String value) {
            addCriterion("FTP_USER like", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserNotLike(String value) {
            addCriterion("FTP_USER not like", value, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserIn(List<String> values) {
            addCriterion("FTP_USER in", values, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserNotIn(List<String> values) {
            addCriterion("FTP_USER not in", values, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserBetween(String value1, String value2) {
            addCriterion("FTP_USER between", value1, value2, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpUserNotBetween(String value1, String value2) {
            addCriterion("FTP_USER not between", value1, value2, "ftpUser");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdIsNull() {
            addCriterion("FTP_PASSWD is null");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdIsNotNull() {
            addCriterion("FTP_PASSWD is not null");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdEqualTo(String value) {
            addCriterion("FTP_PASSWD =", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdNotEqualTo(String value) {
            addCriterion("FTP_PASSWD <>", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdGreaterThan(String value) {
            addCriterion("FTP_PASSWD >", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("FTP_PASSWD >=", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdLessThan(String value) {
            addCriterion("FTP_PASSWD <", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdLessThanOrEqualTo(String value) {
            addCriterion("FTP_PASSWD <=", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdLike(String value) {
            addCriterion("FTP_PASSWD like", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdNotLike(String value) {
            addCriterion("FTP_PASSWD not like", value, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdIn(List<String> values) {
            addCriterion("FTP_PASSWD in", values, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdNotIn(List<String> values) {
            addCriterion("FTP_PASSWD not in", values, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdBetween(String value1, String value2) {
            addCriterion("FTP_PASSWD between", value1, value2, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPasswdNotBetween(String value1, String value2) {
            addCriterion("FTP_PASSWD not between", value1, value2, "ftpPasswd");
            return (Criteria) this;
        }

        public Criteria andFtpPortIsNull() {
            addCriterion("FTP_PORT is null");
            return (Criteria) this;
        }

        public Criteria andFtpPortIsNotNull() {
            addCriterion("FTP_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andFtpPortEqualTo(String value) {
            addCriterion("FTP_PORT =", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortNotEqualTo(String value) {
            addCriterion("FTP_PORT <>", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortGreaterThan(String value) {
            addCriterion("FTP_PORT >", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortGreaterThanOrEqualTo(String value) {
            addCriterion("FTP_PORT >=", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortLessThan(String value) {
            addCriterion("FTP_PORT <", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortLessThanOrEqualTo(String value) {
            addCriterion("FTP_PORT <=", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortLike(String value) {
            addCriterion("FTP_PORT like", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortNotLike(String value) {
            addCriterion("FTP_PORT not like", value, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortIn(List<String> values) {
            addCriterion("FTP_PORT in", values, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortNotIn(List<String> values) {
            addCriterion("FTP_PORT not in", values, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortBetween(String value1, String value2) {
            addCriterion("FTP_PORT between", value1, value2, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andFtpPortNotBetween(String value1, String value2) {
            addCriterion("FTP_PORT not between", value1, value2, "ftpPort");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgIsNull() {
            addCriterion("ENCRYP_ALG is null");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgIsNotNull() {
            addCriterion("ENCRYP_ALG is not null");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgEqualTo(String value) {
            addCriterion("ENCRYP_ALG =", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgNotEqualTo(String value) {
            addCriterion("ENCRYP_ALG <>", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgGreaterThan(String value) {
            addCriterion("ENCRYP_ALG >", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgGreaterThanOrEqualTo(String value) {
            addCriterion("ENCRYP_ALG >=", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgLessThan(String value) {
            addCriterion("ENCRYP_ALG <", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgLessThanOrEqualTo(String value) {
            addCriterion("ENCRYP_ALG <=", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgLike(String value) {
            addCriterion("ENCRYP_ALG like", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgNotLike(String value) {
            addCriterion("ENCRYP_ALG not like", value, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgIn(List<String> values) {
            addCriterion("ENCRYP_ALG in", values, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgNotIn(List<String> values) {
            addCriterion("ENCRYP_ALG not in", values, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgBetween(String value1, String value2) {
            addCriterion("ENCRYP_ALG between", value1, value2, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andEncrypAlgNotBetween(String value1, String value2) {
            addCriterion("ENCRYP_ALG not between", value1, value2, "encrypAlg");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyIsNull() {
            addCriterion("SYS_PUBLIC_KEY is null");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyIsNotNull() {
            addCriterion("SYS_PUBLIC_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyEqualTo(String value) {
            addCriterion("SYS_PUBLIC_KEY =", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyNotEqualTo(String value) {
            addCriterion("SYS_PUBLIC_KEY <>", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyGreaterThan(String value) {
            addCriterion("SYS_PUBLIC_KEY >", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_PUBLIC_KEY >=", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyLessThan(String value) {
            addCriterion("SYS_PUBLIC_KEY <", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("SYS_PUBLIC_KEY <=", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyLike(String value) {
            addCriterion("SYS_PUBLIC_KEY like", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyNotLike(String value) {
            addCriterion("SYS_PUBLIC_KEY not like", value, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyIn(List<String> values) {
            addCriterion("SYS_PUBLIC_KEY in", values, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyNotIn(List<String> values) {
            addCriterion("SYS_PUBLIC_KEY not in", values, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyBetween(String value1, String value2) {
            addCriterion("SYS_PUBLIC_KEY between", value1, value2, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPublicKeyNotBetween(String value1, String value2) {
            addCriterion("SYS_PUBLIC_KEY not between", value1, value2, "sysPublicKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyIsNull() {
            addCriterion("SYS_PRIVATE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyIsNotNull() {
            addCriterion("SYS_PRIVATE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyEqualTo(String value) {
            addCriterion("SYS_PRIVATE_KEY =", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyNotEqualTo(String value) {
            addCriterion("SYS_PRIVATE_KEY <>", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyGreaterThan(String value) {
            addCriterion("SYS_PRIVATE_KEY >", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_PRIVATE_KEY >=", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyLessThan(String value) {
            addCriterion("SYS_PRIVATE_KEY <", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("SYS_PRIVATE_KEY <=", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyLike(String value) {
            addCriterion("SYS_PRIVATE_KEY like", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyNotLike(String value) {
            addCriterion("SYS_PRIVATE_KEY not like", value, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyIn(List<String> values) {
            addCriterion("SYS_PRIVATE_KEY in", values, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyNotIn(List<String> values) {
            addCriterion("SYS_PRIVATE_KEY not in", values, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyBetween(String value1, String value2) {
            addCriterion("SYS_PRIVATE_KEY between", value1, value2, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andSysPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("SYS_PRIVATE_KEY not between", value1, value2, "sysPrivateKey");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("UPDATE_TIME like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("UPDATE_TIME not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("REMARK1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("REMARK1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("REMARK1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("REMARK1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("REMARK1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("REMARK1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("REMARK1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("REMARK1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("REMARK1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("REMARK1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("REMARK1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("REMARK1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("REMARK1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("REMARK2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("REMARK2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("REMARK2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("REMARK2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("REMARK2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("REMARK2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("REMARK2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("REMARK2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("REMARK2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("REMARK2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("REMARK2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("REMARK2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("REMARK2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("REMARK3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("REMARK3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("REMARK3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("REMARK3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("REMARK3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("REMARK3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("REMARK3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("REMARK3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("REMARK3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("REMARK3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("REMARK3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("REMARK3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("REMARK3 not between", value1, value2, "remark3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}