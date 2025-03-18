package com.lijunxi.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.common.result.Result;
import com.lijunxi.common.utils.MD5;
import com.lijunxi.model.system.SysPost;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysPostQueryVo;
import com.lijunxi.model.vo.SysUserQueryVo;
import com.lijunxi.system.annotation.Log;
import com.lijunxi.system.enums.BusinessType;
import com.lijunxi.system.service.ISysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-17
 */
@Api(tags ="岗位管理")
@RestController
@RequestMapping("/admin/system/sysPost")
public class SysPostController {

    private final ISysPostService sysPostService;

    @Autowired
    public SysPostController(ISysPostService sysPostService) {
        this.sysPostService = sysPostService;
    }

    /**
     * 分页查询
     *
     * @param sysPostQueryVo 查询条件对象，包含查询所需的信息
     * @return 分页查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping("selectPage")
    public Result<?> selectPageHandler(SysPostQueryVo sysPostQueryVo) {

        Long pageNum = sysPostQueryVo.getPageNum();
        Long pageSize = sysPostQueryVo.getPageSize();
        Page<SysUser> pageParams = new Page<>(pageNum, pageSize);
        IPage<SysPost> sysPostIPage = sysPostService.selectPage(pageParams,sysPostQueryVo);
        return Result.ok(sysPostIPage);
    }

    @Log(title = "岗位管理", businessType = BusinessType.INSERT)
    @ApiOperation("添加岗位")
    @PostMapping("addPost")
    public Result<?> addUser(@RequestBody SysPost sysPost) {
        QueryWrapper<SysPost> queryUserWrapper = new QueryWrapper<>();

        queryUserWrapper.eq("name", sysPost.getName());
        int count = sysPostService.count(queryUserWrapper);
        if (count > 0) {
            return Result.fail().message("岗位已存在");
        }

        boolean isSuccess = sysPostService.save(sysPost);

        return isSuccess ? Result.ok() : Result.fail();
    }

    /**
     * @param id 用户id
     * @return 用户信息
     */
    @ApiOperation("根据id查询")
    @GetMapping("getPost/{id}")
    public Result<?> findById(@PathVariable String id) {
        SysPost sysPost = sysPostService.getById(id);
        return Result.ok(sysPost);
    }

    /**
     * @param id 用户id
     * @return 结果
     */
    @Log(title = "岗位管理", businessType = BusinessType.DELETE)
    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result<?> removeUser(@PathVariable String id) {
        boolean isSuccess = sysPostService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "更新用户")
    @PostMapping("/update")
    public Result<?> updateById(@RequestBody SysPost sysPost) {
        sysPostService.updateById(sysPost);
        return Result.ok();
    }


}
