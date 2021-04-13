package com.lu.common.result;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 编码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;


    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result() {
    }

//    public static Result ResultOK(T data) {
//        return new Result(200, data);
//    }
//
//    public static Result ResultERROR(String message) {
//        return new Result(500, message);
//    }
}
