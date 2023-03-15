package com.develop.liveTogether.application.house.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Option {
    @Column
    @ColumnDefault("'N'")
    private String opAirCon;
    @Column
    @ColumnDefault("'N'")
    private String opCentralHeat;
    @Column
    @ColumnDefault("'N'")
    private String opLocalHeat;
    @Column
    @ColumnDefault("'N'")
    private String opRefrigerator;
    @Column
    @ColumnDefault("'N'")
    private String opWasher;
    @Column
    @ColumnDefault("'N'")
    private String opGasRange;
    @Column
    @ColumnDefault("'N'")
    private String opInduction;
    @Column
    @ColumnDefault("'N'")
    private String opMicrowave;
    @Column
    @ColumnDefault("'N'")
    private String opDesk;
    @Column
    @ColumnDefault("'N'")
    private String opDoorLock;
    @Column
    @ColumnDefault("'N'")
    private String opBed;
    @Column
    @ColumnDefault("'N'")
    private String opCloset;
    @Column
    @ColumnDefault("'N'")
    private String opShoes;
    @Column
    @ColumnDefault("'N'")
    private String opSink;
    @Column
    @ColumnDefault("'N'")
    private String opInterPhone;
    @Column
    @ColumnDefault("'N'")
    private String opWindow;
    @Column
    @ColumnDefault("'N'")
    private String opCctv;
    @Column
    @ColumnDefault("'N'")
    private String opVeranda;
    @Column
    @ColumnDefault("'N'")
    private String opDelivery;
    @Column
    @ColumnDefault("'N'")
    private String opFireAlarm;
    @Column
    @ColumnDefault("'N'")
    private String houseParking;
    @Column
    @ColumnDefault("'N'")
    private String houseElevator;
    @Column
    @ColumnDefault("'N'")
    private String housePet;

    public Option(String opAirCon, String opCentralHeat,
                  String opLocalHeat, String opRefrigerator,
                  String opWasher, String opGasRange,
                  String opInduction, String opMicrowave,
                  String opDesk, String opDoorLock,
                  String opBed, String opCloset,
                  String opShoes, String opSink,
                  String opInterPhone, String opWindow,
                  String opCctv, String opVeranda,
                  String opDelivery, String opFireAlarm,
                  String houseParking, String houseElevator,
                  String housePet)
    {
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
