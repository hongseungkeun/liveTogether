package com.develop.liveTogether.application.house.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Option {
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opAirCon;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opCentralHeat;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opLocalHeat;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opRefrigerator;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opWasher;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opGasRange;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opInduction;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opMicrowave;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opDesk;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opDoorLock;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opBed;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opCloset;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opShoes;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opSink;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opInterPhone;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opWindow;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opCctv;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opVeranda;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opDelivery;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean opFireAlarm;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean houseParking;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean houseElevator;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean housePet;

    @Builder
    public Option(Boolean opAirCon, Boolean opCentralHeat,
                  Boolean opLocalHeat, Boolean opRefrigerator,
                  Boolean opWasher, Boolean opGasRange,
                  Boolean opInduction, Boolean opMicrowave,
                  Boolean opDesk, Boolean opDoorLock,
                  Boolean opBed, Boolean opCloset,
                  Boolean opShoes, Boolean opSink,
                  Boolean opInterPhone, Boolean opWindow,
                  Boolean opCctv, Boolean opVeranda,
                  Boolean opDelivery, Boolean opFireAlarm,
                  Boolean houseParking, Boolean houseElevator,
                  Boolean housePet) {
        isNullElseDefaultOpAirCon(opAirCon);
        isNullElseDefaultOpCentralHeat(opCentralHeat);
        isNullElseDefaultOpLocalHeat(opLocalHeat);
        isNullElseDefaultOpRefrigerator(opRefrigerator);
        isNullElseDefaultOpWasher(opWasher);
        isNullElseDefaultOpGasRange(getOpGasRange());
        isNullElseDefaultOpInduction(opInduction);
        isNullElseDefaultOpMicrowave(opMicrowave);
        isNullElseDefaultOpDesk(opDesk);
        isNullElseDefaultOpDoorLock(opDoorLock);
        isNullElseDefaultOpBed(opBed);
        isNullElseDefaultOpCloset(opCloset);
        isNullElseDefaultOpShoes(opShoes);
        isNullElseDefaultOpSink(opSink);
        isNullElseDefaultOpInterPhone(opInterPhone);
        isNullElseDefaultOpWindow(opWindow);
        isNullElseDefaultOpCctv(opCctv);
        isNullElseDefaultOpVeranda(opVeranda);
        isNullElseDefaultOpDelivery(opDelivery);
        isNullElseDefaultOpFireAlarm(opFireAlarm);
        isNullElseDefaultHouseParking(houseParking);
        isNullElseDefaultHouseElevator(houseElevator);
        isNullElseDefaultHousePet(housePet);
    }

    public void isNullElseDefaultOpAirCon(Boolean opAirCon) {
        this.opAirCon = Objects.requireNonNullElse(opAirCon, false);
    }

    public void isNullElseDefaultOpCentralHeat(Boolean opCentralHeat) {
        this.opCentralHeat = Objects.requireNonNullElse(opCentralHeat, false);
    }

    public void isNullElseDefaultOpLocalHeat(Boolean opLocalHeat) {
        this.opLocalHeat = Objects.requireNonNullElse(opLocalHeat, false);
    }

    public void isNullElseDefaultOpRefrigerator(Boolean opRefrigerator) {
        this.opRefrigerator = Objects.requireNonNullElse(opRefrigerator, false);
    }

    public void isNullElseDefaultOpWasher(Boolean opWasher) {
        this.opWasher = Objects.requireNonNullElse(opWasher, false);
    }

    public void isNullElseDefaultOpGasRange(Boolean opGasRange) {
        this.opGasRange = Objects.requireNonNullElse(opGasRange, false);
    }

    public void isNullElseDefaultOpInduction(Boolean opInduction) {
        this.opInduction = Objects.requireNonNullElse(opInduction, false);
    }

    public void isNullElseDefaultOpMicrowave(Boolean opMicrowave) {
        this.opMicrowave = Objects.requireNonNullElse(opMicrowave, false);
    }

    public void isNullElseDefaultOpDesk(Boolean opDesk) {
        this.opDesk = Objects.requireNonNullElse(opDesk, false);
    }

    public void isNullElseDefaultOpDoorLock(Boolean opDoorLock) {
        this.opDoorLock = Objects.requireNonNullElse(opDoorLock, false);
    }

    public void isNullElseDefaultOpBed(Boolean opBed) {
        this.opBed = Objects.requireNonNullElse(opBed, false);
    }

    public void isNullElseDefaultOpCloset(Boolean opCloset) {
        this.opCloset = Objects.requireNonNullElse(opCloset, false);
    }

    public void isNullElseDefaultOpShoes(Boolean opShoes) {
        this.opShoes = Objects.requireNonNullElse(opShoes, false);
    }

    public void isNullElseDefaultOpSink(Boolean opSink) {
        this.opSink = Objects.requireNonNullElse(opSink, false);
    }

    public void isNullElseDefaultOpInterPhone(Boolean opInterPhone) {
        this.opInterPhone = Objects.requireNonNullElse(opInterPhone, false);
    }

    public void isNullElseDefaultOpWindow(Boolean opWindow) {
        this.opWindow = Objects.requireNonNullElse(opWindow, false);
    }

    public void isNullElseDefaultOpCctv(Boolean opCctv) {
        this.opCctv = Objects.requireNonNullElse(opCctv, false);
    }

    public void isNullElseDefaultOpVeranda(Boolean opVeranda) {
        this.opVeranda = Objects.requireNonNullElse(opVeranda, false);
    }

    public void isNullElseDefaultOpDelivery(Boolean opDelivery) {
        this.opDelivery = Objects.requireNonNullElse(opDelivery, false);
    }

    public void isNullElseDefaultOpFireAlarm(Boolean opFireAlarm) {
        this.opFireAlarm = Objects.requireNonNullElse(opFireAlarm, false);
    }

    public void isNullElseDefaultHouseParking(Boolean houseParking) {
        this.houseParking = Objects.requireNonNullElse(houseParking, false);
    }

    public void isNullElseDefaultHouseElevator(Boolean houseElevator) {
        this.houseElevator = Objects.requireNonNullElse(houseElevator, false);
    }

    public void isNullElseDefaultHousePet(Boolean housePet) {
        this.housePet = Objects.requireNonNullElse(housePet, false);
    }
}
