package com.develop.liveTogether.application.house.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
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

}
