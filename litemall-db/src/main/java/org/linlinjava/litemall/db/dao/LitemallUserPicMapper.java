package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallUserPic;
import org.linlinjava.litemall.db.domain.LitemallUserPicExample;
public interface LitemallUserPicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    long countByExample(LitemallUserPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int deleteByExample(LitemallUserPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int insert(LitemallUserPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int insertSelective(LitemallUserPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    List<LitemallUserPic> selectByExample(LitemallUserPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    LitemallUserPic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int updateByExampleSelective(@Param("record") LitemallUserPic record, @Param("example") LitemallUserPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int updateByExample(@Param("record") LitemallUserPic record, @Param("example") LitemallUserPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int updateByPrimaryKeySelective(LitemallUserPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pic
     *
     * @mbg.generated Wed Nov 09 09:22:05 CST 2022
     */
    int updateByPrimaryKey(LitemallUserPic record);
}
