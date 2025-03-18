package com.lijunxi.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lijunxi.model.system.SysDept;

import com.lijunxi.system.mapper.SysDeptMapper;
import com.lijunxi.system.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author lijunxi
 * @since 2025-03-15
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    final private SysDeptMapper sysDeptMapper;

    public SysDeptServiceImpl(SysDeptMapper sysDeptMapper) {
        this.sysDeptMapper = sysDeptMapper;
    }


    @Override
    public List<SysDept> getDeptTree() {
        // 查询所有未删除的部门
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
        wrapper.eq("is_deleted", 0);
        List<SysDept> allDepts = sysDeptMapper.selectList(wrapper);

        // 按 sort_value 排序
        Collections.sort(allDepts, new Comparator<SysDept>() {
            @Override
            public int compare(SysDept o1, SysDept o2) {
                return o1.getSortValue().compareTo(o2.getSortValue());
            }
        });

        // 构建树状结构
        return buildTree(allDepts);
    }

    @Override
    @Transactional
    public void saveDept(SysDept sysDept) {
        // 设置默认值
        if (sysDept.getStatus() == null) {
            sysDept.setStatus(1); // 默认正常状态
        }
        if (sysDept.getSortValue() == null) {
            sysDept.setSortValue(1); // 默认排序值
        }

        // 处理 tree_path
        Long parentId = sysDept.getParentId();
        if (parentId == null || parentId == 0) {
            // 顶级部门
            sysDept.setTreePath("," + sysDept.getId() + ",");
        } else {
            // 获取父部门的 tree_path
            SysDept parentDept = this.getById(parentId);
            if (parentDept == null) {
                throw new RuntimeException("父部门不存在");
            }
            sysDept.setTreePath(parentDept.getTreePath() + sysDept.getId() + ",");
        }

        // 保存部门
        this.save(sysDept);

        // 更新 tree_path（因为 ID 是自增的，需保存后重新设置）
        if (parentId == null || parentId == 0) {
            sysDept.setTreePath("," + sysDept.getId() + ",");
        } else {
            SysDept parentDept = this.getById(parentId);
            sysDept.setTreePath(parentDept.getTreePath() + sysDept.getId() + ",");
        }
        this.updateById(sysDept);
    }

    @Override
    @Transactional
    public void updateDept(SysDept sysDept) {
        // 检查部门是否存在
        SysDept existingDept = this.getById(sysDept.getId());
        if (existingDept == null) {
            throw new RuntimeException("部门不存在");
        }

        // 更新 tree_path（如果 parentId 发生变化）
        Long newParentId = sysDept.getParentId();
        Long oldParentId = existingDept.getParentId();
        if (!newParentId.equals(oldParentId)) {
            if (newParentId == null || newParentId == 0) {
                sysDept.setTreePath("," + sysDept.getId() + ",");
            } else {
                SysDept newParentDept = this.getById(newParentId);
                if (newParentDept == null) {
                    throw new RuntimeException("新父部门不存在");
                }
                sysDept.setTreePath(newParentDept.getTreePath() + sysDept.getId() + ",");
            }
        }

        // 更新部门信息
        this.updateById(sysDept);
    }

    @Override
    @Transactional
    public void removeDept(Long id) {
        // 检查部门是否存在
        SysDept dept = this.getById(id);
        if (dept == null) {
            throw new RuntimeException("部门不存在");
        }

        // 检查是否有子部门
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDept::getParentId, id)
                .eq(SysDept::getIsDeleted, 0); // 只查询未删除的子部门
        long childCount = this.count(wrapper);
        if (childCount > 0) {
            throw new RuntimeException("该部门下存在子部门，无法删除");
        }

        // 执行逻辑删除
        this.removeById(id);
    }

    private List<SysDept> buildTree(List<SysDept> depts) {
        // 将部门列表转为 Map
        Map<Long, SysDept> deptMap = new HashMap<Long, SysDept>();
        for (SysDept dept : depts) {
            deptMap.put(Long.valueOf(dept.getId()), dept);
            // 确保 children 初始化（避免 null）
            if (dept.getChildren() == null) {
                dept.setChildren(new ArrayList<SysDept>());
            }
        }

        // 存储顶级部门
        List<SysDept> rootList = new ArrayList<SysDept>();

        // 遍历构建树
        for (SysDept dept : depts) {
            if (dept.getParentId() == 0) {
                rootList.add(dept);
            } else {
                SysDept parent = deptMap.get(dept.getParentId());
                if (parent != null) {
                    parent.getChildren().add(dept);
                }
            }
        }

        return rootList;
    }
}
