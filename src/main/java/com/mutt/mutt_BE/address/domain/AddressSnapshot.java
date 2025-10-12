package com.mutt.mutt_BE.address.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * 배송지 스냅샷 (@Embeddable)
 * 주문/결제 당시의 배송지 정보를 불변 값으로 보관
 * Address 엔티티가 수정/삭제되어도 주문 이력은 유지됨
 *
 * 사용처:
 * - Order (주문 시점 배송지)
 * - IdeaFeeTransaction (아이디어 등록비 결제 시점 배송지)
 *
 * @see Address
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AddressSnapshot {
    
    @Column(nullable = false)
    private String recipientName;
    
    @Column(nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    private String zipCode;
    
    @Column(nullable = false)
    private String streetAddress;
    
    private String detailedAddress;

    public static AddressSnapshot from(Address address){
        if (address == null)  return null;

        return new AddressSnapshot(
                address.getRecipientName(),
                address.getPhoneNumber(),
                address.getZipCode(),
                address.getStreetAddress(),
                address.getDetailedAddress()
        );
    }
}
