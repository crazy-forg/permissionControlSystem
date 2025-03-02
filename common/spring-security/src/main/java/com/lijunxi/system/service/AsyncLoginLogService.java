package com.lijunxi.system.service;

import org.springframework.stereotype.Service;

/**
 * 异步调用日志服务
 */

public interface AsyncLoginLogService {

    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status 状态
     * @param ipaddr ip
     * @param message 消息内容
     * @return
     */
    void recordLoginLog(String username, Integer status, String ipaddr, String message);
}
