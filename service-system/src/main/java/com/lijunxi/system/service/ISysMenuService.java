package com.lijunxi.system.service;

import com.lijunxi.model.system.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.vo.AssginMenuVo;
import com.lijunxi.model.vo.RouterVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-10
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 菜单树形数据
     * @return
     */
    List<SysMenu> findNodes();

    /**
     * 根据角色获取授权权限数据
     * @return
     */
    List<SysMenu> findSysMenuByRoleId(String roleId);

    /**
     * 保存角色权限
     * @param  assginMenuVo
     */
    void doAssign(AssginMenuVo assginMenuVo);

    List<RouterVo> getUserMenuList(String id);

    List<String> getUserButtonList(String id);
}
