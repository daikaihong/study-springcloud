package com.atguigu.springcloud.sys;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public Result<T> error(int code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public Result<T> error(String message) {
        this.code = 500;
        this.message = message;
        return this;
    }

    public void setData(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }
}
