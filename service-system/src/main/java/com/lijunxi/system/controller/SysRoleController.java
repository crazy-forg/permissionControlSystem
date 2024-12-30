package com.lijunxi.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysRole;
import com.lijunxi.model.vo.BatchDeleteRequestVo;
import com.lijunxi.model.vo.SysRoleAddVo;
import com.lijunxi.model.vo.SysRoleQueryVo;
import com.lijunxi.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }


    /**
     * 修改角色
     * @param role
     * @return
     */
    @ApiOperation("修改角色")
    @PostMapping("updateRole")
    public Result<?> updateRole(@RequestBody SysRole role) {
        SysRole sysRole = sysRoleService.selectOne(Long.valueOf(role.getId()));
        if (sysRole != null) {
            sysRole.setRoleName(role.getRoleName());
            sysRole.setRoleCode(role.getRoleCode());
            sysRole.setDescription(role.getDescription());
            boolean isSuccess = sysRoleService.updateById(sysRole);
            return isSuccess ? Result.ok() : Result.fail();
        }

        return Result.fail("角色不存在");

    }


    /**
     * 新增角色
     * @param sysRoleAddVo 新增角色条件对象
     * @return
     */
    @ApiOperation("添加角色")
    @PostMapping("addRole")
    public Result<?> addRole(@RequestBody SysRoleAddVo sysRoleAddVo ) {
        boolean isSuccess = sysRoleService.save(sysRoleAddVo);
        return isSuccess ? Result.ok() : Result.fail();
    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ApiOperation("根据id查询角色")
    @GetMapping("findRoleById/{id}")
    public Result<?> findRoleById(@PathVariable Long id) {

        if (id == null) {
            return Result.fail("id不能为空");
        }
        //调用service
        SysRole role = sysRoleService.selectOne(id);
        if (role != null) {
            return Result.ok(role);
        }
        return Result.fail("角色不存在");
    }


    /**
     * 查询所有记录
     * @return
     */
    @ApiOperation("查询所有角色")
    @GetMapping("findAll")
    public Result<?> findAll() {
        //调用service
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }


    /**
     * 分页查询
     * @param sysRoleQueryVo 角色查询条件对象，包含查询所需的角色信息
     * @return
     */
    @ApiOperation("分页查询")
    @GetMapping("selectPage")
    public Result<?> findQueryRole( SysRoleQueryVo sysRoleQueryVo) {
        // 创建page
        Long pageNum = sysRoleQueryVo.getPageNum();
        Long pageSize = sysRoleQueryVo.getPageSize();
        Page<SysRole> pageParams = new Page<>(pageNum, pageSize);
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParams, sysRoleQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @ApiOperation("删除角色")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable("id") Long id) {
        boolean isSuccess = sysRoleService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }

    /**
     * 批量删除
     * @param batchDeleteRequestVo
     * @return
     */
    @ApiOperation("批量删除")
    @PostMapping("batchDelete")
    public Result<?> batchDelete(@RequestBody BatchDeleteRequestVo batchDeleteRequestVo) {
        List<Long> ids = batchDeleteRequestVo.getIds();
        if(ids == null || ids.isEmpty()) {
            return Result.fail("id数组不能为空");
        }
        boolean isSuccess = sysRoleService.removeByIds(ids);
        return isSuccess ? Result.ok() : Result.fail();
    }
}
