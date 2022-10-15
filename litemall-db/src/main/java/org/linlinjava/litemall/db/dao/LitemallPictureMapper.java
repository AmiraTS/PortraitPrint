package org.linlinjava.litemall.db.dao;

import org.linlinjava.litemall.db.domain.LitemallPicture;
import org.linlinjava.litemall.db.domain.LitemallPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallPictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    long countByExample(LitemallPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int deleteByExample(LitemallPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int insert(LitemallPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int insertSelective(LitemallPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    List<LitemallPicture> selectByExample(LitemallPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    LitemallPicture selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int updateByExampleSelective(@Param("record") LitemallPicture record, @Param("example") LitemallPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int updateByExample(@Param("record") LitemallPicture record, @Param("example") LitemallPictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int updateByPrimaryKeySelective(LitemallPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_picture
     *
     * @mbg.generated Sat Oct 15 15:29:23 CST 2022
     */
    int updateByPrimaryKey(LitemallPicture record);
}
