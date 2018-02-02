package com.vkl.fzmz.sys.service.impl;

import com.vkl.fzmz.common.base.BaseResult;
import com.vkl.fzmz.common.base.EUDataGridResult;
import com.vkl.fzmz.sys.dao.SysUserOrgMapper;
import com.vkl.fzmz.sys.web.form.SysUserOrgForm;
import com.vkl.fzmz.sys.convert.SysUserOrgConvert;
import com.vkl.fzmz.sys.domain.SysUserOrg;
import com.vkl.fzmz.sys.domain.SysUserOrgExample;
import com.vkl.fzmz.sys.service.SysUserOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysUserOrgServiceImpl implements SysUserOrgService {

    @Autowired
    SysUserOrgMapper sysUserOrgMapper;

    public BaseResult delete(Long id) {
        sysUserOrgMapper.deleteByPrimaryKey(id);
        return BaseResult.ok("删除成功");
    }

    @Override
    public BaseResult deleteByIds(String ids) {
        SysUserOrgExample example = new SysUserOrgExample();
        example.createCriteria().andIdIn(idsToList(ids));
        sysUserOrgMapper.deleteByExample(example);
        return BaseResult.ok("删除成功");
    }

    @Override
    public BaseResult get(Long id) {
        SysUserOrg sysUserOrg = sysUserOrgMapper.selectByPrimaryKey(id);
        return BaseResult.ok("查询成功", SysUserOrgConvert.entityToForm(sysUserOrg));
    }

    @Override
    public BaseResult list(SysUserOrgForm form) {
        SysUserOrgExample example = new SysUserOrgExample();
        List<SysUserOrg> sysUserOrgList = sysUserOrgMapper.selectByExample(example);
        return BaseResult.ok("查询成功", SysUserOrgConvert.entityListToFormList(sysUserOrgList));
    }

    @Override
    public EUDataGridResult listPage(SysUserOrgForm form) {
        SysUserOrgExample example = new SysUserOrgExample();
        //设置分页
        example.setStart((form.getPage() - 1) * form.getRows());
        example.setSize(form.getRows());

        //查询条件
        if (form != null) {
            SysUserOrgExample.Criteria criteria = example.createCriteria();

            //其它条件

        }

        //查询总记录
        long count = sysUserOrgMapper.countByExample(example);
        //查询分页列表
        List<SysUserOrg> sysUserOrgList = sysUserOrgMapper.selectPageByExample(example);

        //返回结果
        EUDataGridResult result = new EUDataGridResult(count, SysUserOrgConvert.entityListToFormList(sysUserOrgList));
        return result;
    }

    @Override
    public BaseResult saveOrUpdate(SysUserOrgForm form) {
        SysUserOrg entity = SysUserOrgConvert.formToEntity(form);
        if (entity.getId() != null) {
            sysUserOrgMapper.updateByPrimaryKey(entity);
        } else {
            sysUserOrgMapper.insert(entity);
        }
        return BaseResult.ok("保存成功");
    }

    @Override
    public BaseResult update(SysUserOrgForm form) {
        SysUserOrgExample example = new SysUserOrgExample();
        sysUserOrgMapper.updateByExample(SysUserOrgConvert.formToEntity(form), example);
        return BaseResult.ok("更新成功");
    }

    private List<Long> idsToList(String ids) {
        String[] id = ids.split(",");
        List<Long> idList = new ArrayList<>();
            for (int i = 0; i < id.length; i++) {
            idList.add(Long.parseLong(id[i]));
        }
        return idList;
    }
}