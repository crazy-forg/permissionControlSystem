package com.lijunxi.system.service.impl;

import com.lijunxi.model.system.SysLoginLog;
import com.lijunxi.system.mapper.SysLoginLogMapper;
import com.lijunxi.system.service.AsyncLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AsyncLoginLogServiceImpl implements AsyncLoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;


    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status 状态
     * @param ipaddr ip
     * @param message 消息内容
     * @return
     */
    @Override
    public void recordLoginLog(String username, Integer status, String ipaddr, String message) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(username);
        sysLoginLog.setIpaddr(ipaddr);
        sysLoginLog.setMsg(message);
        // 日志状态
        sysLoginLog.setStatus(status);
        sysLoginLogMapper.insert(sysLoginLog);
    }
}
