package com.lijunxi.system.test;



import com.lijunxi.model.system.SysRole;
import com.lijunxi.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Test
    public void testFindAll() {
      List<SysRole> list =   sysRoleMapper.selectList(null);
      for (SysRole sysRole : list) {
          System.out.println(sysRole);
      }

    }
}
