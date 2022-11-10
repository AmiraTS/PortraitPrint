package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.LitemallDesign;
import org.linlinjava.litemall.db.domain.LitemallDesignExample;
public interface LitemallDesignMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    long countByExample(LitemallDesignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallDesignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int insert(LitemallDesign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int insertSelective(LitemallDesign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    LitemallDesign selectOneByExample(LitemallDesignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    LitemallDesign selectOneByExampleSelective(@Param("example") LitemallDesignExample example, @Param("selective") LitemallDesign.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    List<LitemallDesign> selectByExampleSelective(@Param("example") LitemallDesignExample example, @Param("selective") LitemallDesign.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    List<LitemallDesign> selectByExample(LitemallDesignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    LitemallDesign selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallDesign.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    LitemallDesign selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    LitemallDesign selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallDesign record, @Param("example") LitemallDesignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallDesign record, @Param("example") LitemallDesignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallDesign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallDesign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallDesignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_design
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}