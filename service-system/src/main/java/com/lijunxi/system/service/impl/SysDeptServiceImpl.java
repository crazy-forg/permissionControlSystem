package com.lijunxi.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lijunxi.model.system.SysDept;

import com.lijunxi.system.mapper.SysDeptMapper;
import com.lijunxi.system.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
