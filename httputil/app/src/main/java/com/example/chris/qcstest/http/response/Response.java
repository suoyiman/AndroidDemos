package com.example.chris.qcstest.http.response;

/**
 * Created by chris on 17-4-10.
 */

public class Response<T> {

    /**
     * success : true
     * data : null
     * errCode : null
     * errMsg : null
     * id : null
     * errorMessage : null
     * message : 登录成功
     */

    private boolean success;
    private T data;
    private Object errCode;
    private Object errMsg;
    private Object id;
    private Object errorMessage;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrCode() {
        return errCode;
    }

    public void setErrCode(Object errCode) {
        this.errCode = errCode;
    }

    public Object getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(Object errMsg) {
        this.errMsg = errMsg;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
