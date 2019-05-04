package com.emedclub.news.entity;

import org.springframework.http.HttpStatus;

/**
 * Created by IntelliJ IDEA
 * Author: Jinchao WU
 * Email: wujc12@live.com
 * Date: 2019/05/04
 */
public class ResponseBody {
    private boolean success;

    private HttpStatus httpStatus;

    public ResponseBody(boolean success, HttpStatus httpStatus) {
        this.success = success;
        this.httpStatus = httpStatus;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
