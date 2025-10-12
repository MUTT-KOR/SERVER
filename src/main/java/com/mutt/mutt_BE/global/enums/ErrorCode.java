package com.mutt.mutt_BE.global.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    //유저 : 예시
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"U001", "해당 사용자를 찾을 수 없습니다");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


}
