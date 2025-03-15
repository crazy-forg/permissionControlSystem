package com.lijunxi.system.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lijunxi.model.system.SysRole;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.system.mapper.SysRoleMapper;
import com.lijunxi.system.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;


    @Test
    public void findAllUser() {
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        System.out.println(sysUsers);
    }


    @Test
    public void testFindAll() {
        List<SysRole> list = sysRoleMapper.selectList(null);
        for (SysRole sysRole : list) {
            System.out.println(sysRole);
        }

    }

    @Test
    public void testFindById() {
        SysRole sysRole = sysRoleMapper.selectById(1);
        System.out.println(sysRole);
    }

    @Test
    public void testSave() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("test");
        sysRole.setRoleCode("testAdd3");
        sysRole.setDescription("testRole");
        int rows = sysRoleMapper.insert(sysRole);

        System.out.println(rows);

    }

    @Test
    public void testUpdate() {
        SysRole sysRole = sysRoleMapper.selectById(9);
        sysRole.setRoleName("testUpdate1111");
        int rows = sysRoleMapper.updateById(sysRole);
        System.out.println(rows);

    }

    @Test
    public void testDelete() {
        int rows = sysRoleMapper.deleteById(9);
        System.out.println(rows);

    }

    @Test
    public void testBatchDelete() {
        int rows = sysRoleMapper.deleteBatchIds(Arrays.asList(9, 10, 11, 12));

        System.out.println(rows);

    }

    @Test
    public void testSelect() {
        // 创建条件构造器对象
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("role_name", "系统管理员");

        System.out.println(sysRoleMapper.selectList(queryWrapper));


    }
}

