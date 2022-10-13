package entity;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdmIdIsNull() {
            addCriterion("adm_id is null");
            return (Criteria) this;
        }

        public Criteria andAdmIdIsNotNull() {
            addCriterion("adm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdmIdEqualTo(Integer value) {
            addCriterion("adm_id =", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotEqualTo(Integer value) {
            addCriterion("adm_id <>", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdGreaterThan(Integer value) {
            addCriterion("adm_id >", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adm_id >=", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdLessThan(Integer value) {
            addCriterion("adm_id <", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdLessThanOrEqualTo(Integer value) {
            addCriterion("adm_id <=", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdIn(List<Integer> values) {
            addCriterion("adm_id in", values, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotIn(List<Integer> values) {
            addCriterion("adm_id not in", values, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdBetween(Integer value1, Integer value2) {
            addCriterion("adm_id between", value1, value2, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adm_id not between", value1, value2, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmAcctIsNull() {
            addCriterion("adm_acct is null");
            return (Criteria) this;
        }

        public Criteria andAdmAcctIsNotNull() {
            addCriterion("adm_acct is not null");
            return (Criteria) this;
        }

        public Criteria andAdmAcctEqualTo(String value) {
            addCriterion("adm_acct =", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctNotEqualTo(String value) {
            addCriterion("adm_acct <>", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctGreaterThan(String value) {
            addCriterion("adm_acct >", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctGreaterThanOrEqualTo(String value) {
            addCriterion("adm_acct >=", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctLessThan(String value) {
            addCriterion("adm_acct <", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctLessThanOrEqualTo(String value) {
            addCriterion("adm_acct <=", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctLike(String value) {
            addCriterion("adm_acct like", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctNotLike(String value) {
            addCriterion("adm_acct not like", value, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctIn(List<String> values) {
            addCriterion("adm_acct in", values, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctNotIn(List<String> values) {
            addCriterion("adm_acct not in", values, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctBetween(String value1, String value2) {
            addCriterion("adm_acct between", value1, value2, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmAcctNotBetween(String value1, String value2) {
            addCriterion("adm_acct not between", value1, value2, "admAcct");
            return (Criteria) this;
        }

        public Criteria andAdmPswdIsNull() {
            addCriterion("adm_pswd is null");
            return (Criteria) this;
        }

        public Criteria andAdmPswdIsNotNull() {
            addCriterion("adm_pswd is not null");
            return (Criteria) this;
        }

        public Criteria andAdmPswdEqualTo(String value) {
            addCriterion("adm_pswd =", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdNotEqualTo(String value) {
            addCriterion("adm_pswd <>", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdGreaterThan(String value) {
            addCriterion("adm_pswd >", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdGreaterThanOrEqualTo(String value) {
            addCriterion("adm_pswd >=", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdLessThan(String value) {
            addCriterion("adm_pswd <", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdLessThanOrEqualTo(String value) {
            addCriterion("adm_pswd <=", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdLike(String value) {
            addCriterion("adm_pswd like", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdNotLike(String value) {
            addCriterion("adm_pswd not like", value, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdIn(List<String> values) {
            addCriterion("adm_pswd in", values, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdNotIn(List<String> values) {
            addCriterion("adm_pswd not in", values, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdBetween(String value1, String value2) {
            addCriterion("adm_pswd between", value1, value2, "admPswd");
            return (Criteria) this;
        }

        public Criteria andAdmPswdNotBetween(String value1, String value2) {
            addCriterion("adm_pswd not between", value1, value2, "admPswd");
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