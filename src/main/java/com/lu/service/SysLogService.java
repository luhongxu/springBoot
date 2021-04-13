package com.lu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lu.pojo.entity.SysLog;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lu
 * @since 2021-04-12
 */
public interface SysLogService extends IService<SysLog> {

    Page<SysLog> page(SysLog sysLog, Page<SysLog> page);

}
