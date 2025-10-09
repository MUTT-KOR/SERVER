package com.mutt.mutt_BE.global.exception;

import com.mutt.mutt_BE.global.enums.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errodCode;

    public BusinessException(ErrorCode errodCode) {
        super(errodCode.getMessage());
        this.errodCode = errodCode;
    }

}
