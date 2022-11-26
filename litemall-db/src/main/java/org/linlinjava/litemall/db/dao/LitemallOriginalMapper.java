package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallOriginal;
import org.linlinjava.litemall.db.domain.LitemallOriginalExample;

public interface LitemallOriginalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    long countByExample(LitemallOriginalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallOriginalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer oriId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int insert(LitemallOriginal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int insertSelective(LitemallOriginal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    LitemallOriginal selectOneByExample(LitemallOriginalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    LitemallOriginal selectOneByExampleSelective(@Param("example") LitemallOriginalExample example, @Param("selective") LitemallOriginal.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    List<LitemallOriginal> selectByExampleSelective(@Param("example") LitemallOriginalExample example, @Param("selective") LitemallOriginal.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    List<LitemallOriginal> selectByExample(LitemallOriginalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    LitemallOriginal selectByPrimaryKeySelective(@Param("oriId") Integer oriId, @Param("selective") LitemallOriginal.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    LitemallOriginal selectByPrimaryKey(Integer oriId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    LitemallOriginal selectByPrimaryKeyWithLogicalDelete(@Param("oriId") Integer oriId, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallOriginal record, @Param("example") LitemallOriginalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallOriginal record, @Param("example") LitemallOriginalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallOriginal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallOriginal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallOriginalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_original
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer oriId);
}