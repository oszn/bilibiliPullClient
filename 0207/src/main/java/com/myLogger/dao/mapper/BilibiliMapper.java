package com.myLogger.dao.mapper;

import com.myLogger.dao.entry.Bilibili;
import com.myLogger.dao.entry.BilibiliExample;

public interface BilibiliMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bilibili
     *
     * @mbg.generated Sat Feb 06 17:10:16 CST 2021
     */
    long countByExample(BilibiliExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bilibili
     *
     * @mbg.generated Sat Feb 06 17:10:16 CST 2021
     */
    int deleteByPrimaryKey(Long mid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bilibili
     *
     * @mbg.generated Sat Feb 06 17:10:16 CST 2021
     */
    int insert(Bilibili record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bilibili
     *
     * @mbg.generated Sat Feb 06 17:10:16 CST 2021
     */
    int insertSelective(Bilibili record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bilibili
     *
     * @mbg.generated Sat Feb 06 17:10:16 CST 2021
     */
    Bilibili selectByPrimaryKey(Long mid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bilibili
     *
     * @mbg.generated Sat Feb 06 17:10:16 CST 2021
     */
    int updateByPrimaryKeySelective(Bilibili record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bilibili
     *
     * @mbg.generated Sat Feb 06 17:10:16 CST 2021
     */
    int updateByPrimaryKey(Bilibili record);
}