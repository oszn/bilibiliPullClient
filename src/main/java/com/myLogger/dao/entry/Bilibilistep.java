package com.myLogger.dao.entry;

public class Bilibilistep {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bilibiliStep.name
     *
     * @mbg.generated Fri Feb 19 15:09:54 CST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bilibiliStep.value
     *
     * @mbg.generated Fri Feb 19 15:09:54 CST 2021
     */
    private Long value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bilibiliStep.name
     *
     * @return the value of bilibiliStep.name
     *
     * @mbg.generated Fri Feb 19 15:09:54 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bilibiliStep.name
     *
     * @param name the value for bilibiliStep.name
     *
     * @mbg.generated Fri Feb 19 15:09:54 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bilibiliStep.value
     *
     * @return the value of bilibiliStep.value
     *
     * @mbg.generated Fri Feb 19 15:09:54 CST 2021
     */
    public Long getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bilibiliStep.value
     *
     * @param value the value for bilibiliStep.value
     *
     * @mbg.generated Fri Feb 19 15:09:54 CST 2021
     */
    public void setValue(Long value) {
        this.value = value;
    }
}