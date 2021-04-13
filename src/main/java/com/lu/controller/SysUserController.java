package com.lu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lu.common.result.PageParam;
import com.lu.common.result.Result;
import com.lu.pojo.dto.SysUserAddDto;
import com.lu.pojo.dto.SysUserDto;
import com.lu.pojo.entity.SysUser;
import com.lu.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author lu
 * @since 2021-04-12
 */
@RestController
@RequestMapping("//sys-user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/add")
    public Result add(@RequestBody SysUserAddDto user) {
        return new Result(200, sysUserService.add(user));
    }

    @PutMapping("/update")
    public Result update(@RequestBody SysUserAddDto user) {
        return new Result(200, sysUserService.update(user));
    }


    @GetMapping("/getOne/{id}")
    public Result getOne(@PathVariable Integer id) {
        return new Result(200, sysUserService.getOne(id));
    }

    @PostMapping("/page")
    public Result getOne(PageParam page, @RequestBody SysUserDto sysUserDto) {
        Page<SysUser> p = new Page<>(page.getPage(), page.getLimit());
        return new Result(200, sysUserService.page(sysUserDto, p));
    }
}
