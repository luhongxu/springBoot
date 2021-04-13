package com.lu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lu.pojo.dto.SysUserAddDto;
import com.lu.pojo.dto.SysUserDto;
import com.lu.pojo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lu.pojo.vo.SysUserVo;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author lu
 * @since 2021-04-12
 */
public interface SysUserService extends IService<SysUser> {

    Boolean add(SysUserAddDto userDto);

    Boolean update(SysUserAddDto userDto);

    SysUserVo getOne(Integer id);

    Page<SysUser> page(SysUserDto sysUserDto, Page<SysUser> page);
}
