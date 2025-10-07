package com.mutt.mutt_BE.address.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
