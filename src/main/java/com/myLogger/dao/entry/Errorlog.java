package com.myLogger.dao.entry;

public class Errorlog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ErrorLog.uid
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ErrorLog.mid
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    private Long mid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ErrorLog.errorInfo
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    private String errorinfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ErrorLog.type
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ErrorLog.uid
     *
     * @return the value of ErrorLog.uid
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ErrorLog.uid
     *
     * @param uid the value for ErrorLog.uid
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ErrorLog.mid
     *
     * @return the value of ErrorLog.mid
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public Long getMid() {
        return mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ErrorLog.mid
     *
     * @param mid the value for ErrorLog.mid
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ErrorLog.errorInfo
     *
     * @return the value of ErrorLog.errorInfo
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public String getErrorinfo() {
        return errorinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ErrorLog.errorInfo
     *
     * @param errorinfo the value for ErrorLog.errorInfo
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo == null ? null : errorinfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ErrorLog.type
     *
     * @return the value of ErrorLog.type
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ErrorLog.type
     *
     * @param type the value for ErrorLog.type
     *
     * @mbg.generated Thu Feb 25 14:54:51 CST 2021
     */
    public void setType(Integer type) {
        this.type = type;
    }
}