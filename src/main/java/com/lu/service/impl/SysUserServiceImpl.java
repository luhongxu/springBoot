package com.lu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lu.mapper.SysUserMapper;
import com.lu.pojo.dto.SysUserAddDto;
import com.lu.pojo.dto.SysUserDto;
import com.lu.pojo.entity.SysUser;
import com.lu.pojo.vo.SysUserVo;
import com.lu.service.SysUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author lu
 * @since 2021-04-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Boolean add(SysUserAddDto userDto) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(userDto, sysUser);
        LocalDateTime now = LocalDateTime.now();
        sysUser.setCreateTime(now);
        sysUser.setUpdateTime(now);
        return this.save(sysUser);
    }

    @Override
    public Boolean update(SysUserAddDto userDto) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(userDto, sysUser);
        sysUser.setUpdateTime(LocalDateTime.now());
        return this.updateById(sysUser);
    }

    @Override
    public SysUserVo getOne(Integer id) {
        SysUserVo sysUserVo = new SysUserVo();
        BeanUtil.copyProperties(this.getById(id), sysUserVo);
        return sysUserVo;
    }

    @Override
    public Page<SysUser> page(SysUserDto sysUserDto, Page<SysUser> page) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(sysUserDto.getPhone() != null, "phone", sysUserDto.getPhone());
        return this.page(page, queryWrapper);
    }
}
