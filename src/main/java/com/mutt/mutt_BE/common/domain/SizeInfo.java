package com.mutt.mutt_BE.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 *IDEA , PRODUCT에서 사용하는 사이즈입니다.
 *
 * */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SizeInfo {

    @Column(precision = 6, scale = 2, nullable = false)
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "1000.00")
    private BigDecimal width;  // 최대 1000.00cm (10m)
    
    @Column(precision = 6, scale = 2, nullable = false)
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "1000.00")
    private BigDecimal height;
    
    @Column(precision = 6, scale = 2, nullable = false)
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "1000.00")
    private BigDecimal length;
    
    @Column(length = 10)
    private String dimensionUnit;  // cm 권장
}
