package com.vkl.fzmz.sys.service;

import com.vkl.fzmz.common.base.BaseResult;
import com.vkl.fzmz.common.base.EUDataGridResult;
import com.vkl.fzmz.common.base.Tree;
import com.vkl.fzmz.sys.web.form.SysResourceForm;

import java.util.List;


public interface SysResourceService {

    /**
     * Description: 增加或修改 <br/>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult saveOrUpdate(SysResourceForm form);

    /**
     * Description: 根据条件修改 <br/>
     * 主键或其它条件<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult update(SysResourceForm form);

    /**
     * Description: 根据主键删除 <br/>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult delete(Long id);

    /**
     * Description: 根据主键删除多个 <br/>
     * ids: 1,2,3<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult deleteByIds(String ids);

    /**
     * Description: 根据ID查询 <br/>
     * page: ture 分页 false 查询所有<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult get(Long id);

    /**
     * Description: 查询列表 <br/>
     * page: ture 分页 false 查询所有<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult list(SysResourceForm form);

    /**
     * Description: 查询列表 <br/>
     * page: ture 分页 false 查询所有<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    EUDataGridResult listPage(SysResourceForm form);

    List<Tree> tree(SysResourceForm form);
}