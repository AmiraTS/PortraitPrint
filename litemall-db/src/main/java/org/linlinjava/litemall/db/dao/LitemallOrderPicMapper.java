package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallOrderPic;
import org.linlinjava.litemall.db.domain.LitemallOrderPicExample;
public interface LitemallOrderPicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    long countByExample(LitemallOrderPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallOrderPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int insert(LitemallOrderPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int insertSelective(LitemallOrderPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    LitemallOrderPic selectOneByExample(LitemallOrderPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    LitemallOrderPic selectOneByExampleSelective(@Param("example") LitemallOrderPicExample example, @Param("selective") LitemallOrderPic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    List<LitemallOrderPic> selectByExampleSelective(@Param("example") LitemallOrderPicExample example, @Param("selective") LitemallOrderPic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    List<LitemallOrderPic> selectByExample(LitemallOrderPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    LitemallOrderPic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallOrderPic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    LitemallOrderPic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    LitemallOrderPic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallOrderPic record, @Param("example") LitemallOrderPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallOrderPic record, @Param("example") LitemallOrderPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallOrderPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallOrderPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallOrderPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_pic
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}