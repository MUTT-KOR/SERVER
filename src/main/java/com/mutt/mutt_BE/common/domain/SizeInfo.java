package com.mutt.mutt_BE.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * IDEA, PRODUCT에서 사용하는 사이즈
 * 단위: mm (밀리미터) ,
 * 최대 10m (10,000mm) 통일
 * 예: 100.5cm → 1005mm
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SizeInfo {

    @Column(nullable = false)
    @Min(1)
    @Max(10000)
    private Integer width;
    
    @Column(nullable = false)
    @Min(1)
    @Max(10000)
    private Integer height;
    
    @Column(nullable = false)
    @Min(1)
    @Max(10000)
    private Integer length;
    
    @Column(length = 10)
    private String dimensionUnit;  //mm
    
    // 편의 메서드: cm 단위로 변환
    public double getWidthInCm() {
        return width / 10.0;
    }
    
    public double getHeightInCm() {
        return height / 10.0;
    }
    
    public double getLengthInCm() {
        return length / 10.0;
    }

}
