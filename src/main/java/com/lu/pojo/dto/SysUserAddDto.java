package com.lu.pojo.dto;

import lombok.Data;

@Data
public class SysUserAddDto {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别0男 1女
     */
    private Integer sex;

    /**
     * 备注
     */
    private String remark;

}
