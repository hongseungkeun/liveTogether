package com.develop.liveTogether.application.house.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @Column(nullable = false)
    private String houseAddress;
    @Column(nullable = false)
    private String houseAddressDetail;
    @Column(nullable = false)
    private String houseLocation;
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;

    @Builder
    public Address(String houseAddress, String houseAddressDetail,
                   String houseLocation, double latitude,
                   double longitude)
    {
        this.houseAddress = houseAddress;
        this.houseAddressDetail = houseAddressDetail;
        this.houseLocation = houseLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
