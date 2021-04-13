package com.lu.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author lu
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 请求URL
     */
    private String url;

    /**
     * 请求参数
     */
    private String param;

    /**
     * 请求时间
     */
    private LocalDateTime time;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 返回结果
     */
    private String result;

    /**
     * 异常消息
     */
    private String message;

    /**
     * 描述
     */
    private String remark;

    /**
     * 模块
     */
    private String module;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
