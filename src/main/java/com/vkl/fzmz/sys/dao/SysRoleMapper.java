package com.vkl.fzmz.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.vkl.fzmz.sys.domain.SysRole;
import com.vkl.fzmz.sys.domain.SysRoleExample;


/**
 * @Description: 角色,数据库表为： sys_role<br/>
 * @Autor: Created by JinKun on 2016-12-30.
 */
public interface SysRoleMapper {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    List<SysRole> selectPageByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}