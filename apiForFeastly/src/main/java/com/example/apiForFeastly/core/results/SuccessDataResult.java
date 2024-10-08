package com.example.apiForFeastly.core.results;
public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(T data,Boolean success,String message) {
        super(data, success,message);
    }

    public SuccessDataResult(String message) {
        super(null, true,message);
    }

    public SuccessDataResult() {
        super(null,true);
    }
}

