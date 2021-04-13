package com.lu.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysUserVo {
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

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
