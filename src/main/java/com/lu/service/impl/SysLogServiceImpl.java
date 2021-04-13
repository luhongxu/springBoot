package com.lu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lu.mapper.SysLogMapper;
import com.lu.pojo.entity.SysLog;
import com.lu.service.SysLogService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lu
 * @since 2021-04-12
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public Page<SysLog> page(SysLog sysLog, Page<SysLog> page) {

        return null;
    }


    public static void main(String[] args) {
        BigDecimal a= BigDecimal.valueOf(1);
        BigDecimal b= BigDecimal.valueOf(1);

        BigDecimal c= BigDecimal.valueOf(0);
        BigDecimal d= BigDecimal.valueOf(2);

        System.out.println(a.compareTo(d));
    }
}
