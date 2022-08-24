package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionNotFoundException extends  Exception{
    public ExceptionNotFoundException(String msg){
        super(msg);
    }
}
