package com.lijunxi.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.system.SysDept;
import com.lijunxi.model.system.SysMenu;

import java.util.List;

/**
 * <p>
 * 组织机构 服务类
 * </p>
 *
 * @author lijunxi
 * @since 2025-03-15
 */
public interface ISysDeptService extends IService<SysDept> {

    List<SysDept> getDeptTree();
    void saveDept(SysDept sysDept);
    void updateDept(SysDept sysDept);
    void removeDept(Long id);

}
