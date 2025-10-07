package com.mutt.mutt_BE.common.enums;

public enum ShippingStatus {
    PENDING,        // 배송 준비중
    SHIPPED,        // 배송 시작 (shippedAt 설정)
    IN_TRANSIT,     // 배송 중
    OUT_FOR_DELIVERY, // 배송지 근처 도착
    DELIVERED,      // 배송 완료 (deliveredAt 설정)
    FAILED,         // 배송 실패
    RETURNED        // 반송
}
