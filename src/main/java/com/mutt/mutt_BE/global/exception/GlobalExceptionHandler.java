package com.mutt.mutt_BE.global.exception;


import com.mutt.mutt_BE.global.enums.ErrorCode;
import com.mutt.mutt_BE.global.response.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    ///커스텀예외 (비즈니스)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse> handleBusinessException(BusinessException ex) {
        ErrorCode errorCode= ex.getErrodCode();

        ApiResponse response = new ApiResponse(false,errorCode.getHttpStatus().value(), errorCode.getMessage());

        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }


    // 쿼리 파라미터 없음
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse> handleMissingParameter(MissingServletRequestParameterException ex) {
        String message = ex.getParameterName() + " parameter is missing.";
        ApiResponse response = new ApiResponse(false,HttpStatus.BAD_REQUEST.value(), message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        String message = Arrays.toString(ex.getDetailMessageArguments()) + " argument is missing.";
        ApiResponse response = new ApiResponse(false,HttpStatus.BAD_REQUEST.value(), message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //Request Body에서 enum에 없는 값을 보냈을 때
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        String errorMessage = "존재하지 않는 타입/카테고리 입니다." + ex.getMessage();
        ApiResponse response = new ApiResponse(false, 400, errorMessage, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /*@Size 등 유효검사 */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage =  "Invalid parameter : " + ex.getMessage();
        ApiResponse response = new ApiResponse(false, 400, errorMessage, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }





}
