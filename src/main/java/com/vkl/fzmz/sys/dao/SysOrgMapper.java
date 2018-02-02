package com.vkl.fzmz.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.vkl.fzmz.sys.domain.SysOrg;
import com.vkl.fzmz.sys.domain.SysOrgExample;


/**
 * @Description: 组织机构,数据库表为： sys_org<br/>
 * @Autor: Created by JinKun on 2016-12-30.
 */
public interface SysOrgMapper {
    long countByExample(SysOrgExample example);

    int deleteByExample(SysOrgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    List<SysOrg> selectByExample(SysOrgExample example);

    List<SysOrg> selectPageByExample(SysOrgExample example);

    SysOrg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    int updateByExample(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);
}