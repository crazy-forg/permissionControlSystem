package com.lijunxi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lijunxi.model.system.SysMenu;
import com.lijunxi.model.system.SysRoleMenu;
import com.lijunxi.model.vo.AssginMenuVo;
import com.lijunxi.model.vo.RouterVo;
import com.lijunxi.system.helper.MenuHelper;
import com.lijunxi.system.helper.RouterHelper;
import com.lijunxi.system.mapper.SysMenuMapper;
import com.lijunxi.system.mapper.SysRoleMenuMapper;
import com.lijunxi.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-10
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> findNodes() {
        //全部权限列表
        List<SysMenu> sysMenuList = this.list();
        if (CollectionUtils.isEmpty(sysMenuList)) return null;

        //构建树形数据
        List<SysMenu> result = MenuHelper.buildTree(sysMenuList);
        return result;
    }

    @Override
    public List<SysMenu> findSysMenuByRoleId(String roleId) {
        //获取所有status为1的权限列表
        List<SysMenu> menuList = sysMenuMapper.selectList(new QueryWrapper<SysMenu>().eq("status", 1));
        //根据角色id获取角色权限
        List<SysRoleMenu> roleMenus = sysRoleMenuMapper.selectList(new QueryWrapper<SysRoleMenu>().eq("role_id", roleId));
        //获取该角色已分配的所有权限id
        List<String> roleMenuIds = new ArrayList<>();
        for (SysRoleMenu roleMenu : roleMenus) {
            roleMenuIds.add(roleMenu.getMenuId());
        }
        //遍历所有权限列表
        for (SysMenu sysMenu : menuList) {
            //设置该权限已被分配
            sysMenu.setSelect(roleMenuIds.contains(sysMenu.getId()));
        }
        //将权限列表转换为权限树
        List<SysMenu> sysMenus = MenuHelper.buildTree(menuList);
        return sysMenus;
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        //删除已分配的权限
        sysRoleMenuMapper.delete(new QueryWrapper<SysRoleMenu>().eq("role_id", assginMenuVo.getRoleId()));
        //遍历所有已选择的权限id
        for (String menuId : assginMenuVo.getMenuIdList()) {
            if (menuId != null) {
                //创建SysRoleMenu对象
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setMenuId(menuId);
                sysRoleMenu.setRoleId(assginMenuVo.getRoleId());
                //添加新权限
                sysRoleMenuMapper.insert(sysRoleMenu);
            }
        }
    }

    @Override
    public List<RouterVo> getUserMenuList(String userId) {

        List<SysMenu> sysMenuList = null;

        // 如果userId ==1 是超级管理员
        if ("1".equals(userId)) {
            QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", 1);
            queryWrapper.orderByAsc("sort_value");
            sysMenuList = baseMapper.selectList(queryWrapper);

        } else {
            sysMenuList = baseMapper.findMenuListByUserId(userId);
        }

        // 树形构建
        List<SysMenu> sysMenusTree = MenuHelper.buildTree(sysMenuList);

        // 转换为前端所需数据结构
        return RouterHelper.buildRouters(sysMenusTree);
    }

    @Override
    public List<String> getUserButtonList(String userId) {
        List<SysMenu> sysMenuList = null;

        // 如果userId ==1 是超级管理员
        if ("1".equals(userId)) {
            sysMenuList = baseMapper.selectList(new QueryWrapper<SysMenu>().eq("status", 1));
        } else {
            sysMenuList = baseMapper.findMenuListByUserId(userId);
        }

        //遍历获取按钮权限集合
        List<String> buttonList = new ArrayList<>();

        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getType() == 2) {
                String permission = sysMenu.getPerms();
                buttonList.add(permission);
            }

        }

        return buttonList;
    }
}
