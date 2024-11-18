package com.example.qingtingserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private Integer code;
    private String message;
    private Object data;
    public static Result success(Object data) {
        ResultStatus status = ResultStatus.SUCCESS;
        return new Result(status.getValue(), status.getMessage(), data);
    }

    public static Result success() {
        ResultStatus status = ResultStatus.SUCCESS;
        return new Result(status.getValue(), status.getMessage(), null);
    }

    public static Result error(String message) {
        ResultStatus status = ResultStatus.ERROR;
        return new Result(status.getValue(), message == null ? status.getMessage() : message, null);
    }

}



enum ResultStatus {
    SUCCESS(200),
    ERROR(500);

    private final int value; // 枚举常量的值

    // 构造函数，传入每个枚举常量的值
    ResultStatus(int value) {
        this.value = value;
    }

    // 获取枚举常量的值
    public int getValue() {
        return value;
    }

    public String getMessage() {
        if (value == 200) {
            return "success";
        }
        else if (value == 500) {
            return "error";
        }
        return "undefined";
    }
}

