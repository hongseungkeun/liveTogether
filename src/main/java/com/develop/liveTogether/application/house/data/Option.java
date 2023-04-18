package com.develop.liveTogether.application.house.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option {
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opAirCon;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opCentralHeat;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opLocalHeat;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opRefrigerator;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opWasher;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opGasRange;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opInduction;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opMicrowave;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opDesk;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opDoorLock;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opBed;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opCloset;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opShoes;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opSink;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opInterPhone;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opWindow;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opCctv;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opVeranda;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opDelivery;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean opFireAlarm;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean houseParking;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean houseElevator;
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean housePet;

    @Builder
    public Option(boolean opAirCon, boolean opCentralHeat,
                  boolean opLocalHeat, boolean opRefrigerator,
                  boolean opWasher, boolean opGasRange,
                  boolean opInduction, boolean opMicrowave,
                  boolean opDesk, boolean opDoorLock,
                  boolean opBed, boolean opCloset,
                  boolean opShoes, boolean opSink,
                  boolean opInterPhone, boolean opWindow,
                  boolean opCctv, boolean opVeranda,
                  boolean opDelivery, boolean opFireAlarm,
                  boolean houseParking, boolean houseElevator,
                  boolean housePet) {
        this.opAirCon = opAirCon;
        this.opCentralHeat = opCentralHeat;
        this.opLocalHeat = opLocalHeat;
        this.opRefrigerator = opRefrigerator;
        this.opWasher = opWasher;
        this.opGasRange = opGasRange;
        this.opInduction = opInduction;
        this.opMicrowave = opMicrowave;
        this.opDesk = opDesk;
        this.opDoorLock = opDoorLock;
        this.opBed = opBed;
        this.opCloset = opCloset;
        this.opShoes = opShoes;
        this.opSink = opSink;
        this.opInterPhone = opInterPhone;
        this.opWindow = opWindow;
        this.opCctv = opCctv;
        this.opVeranda = opVeranda;
        this.opDelivery = opDelivery;
        this.opFireAlarm = opFireAlarm;
        this.houseParking = houseParking;
        this.houseElevator = houseElevator;
        this.housePet = housePet;
    }
}
