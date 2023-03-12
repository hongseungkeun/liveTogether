package com.develop.liveTogether.app.house.entity;

import jakarta.persistence.*;

@Entity
public class HouseVO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int houseNumber;
	@Column(nullable = false)
	private int houseMax;
	@Column(nullable = false)
	private String houseStatus;
	@Column(nullable = false)
	private String houseType;
	@Column(nullable = false)
	private String houseAddress;
	@Column(nullable = false)
	private String houseAddressDetail;
	@Column(nullable = false)
	private String houseLocation;
	@Column(nullable = false)
	private String houseGender;
	private String opAirCon;
	private String opCentralHeat;
	private String opLocalHeat;
	private String opRefrigerator;
	private String opWasher;
	private String opGasRange;
	private String opInduction;
	private String opMicrowave;
	private String opDesk;
	private String opDoorLock;
	private String opBed;
	private String opCloset;
	private String opShoes;
	private String opSink;
	private String opInterPhone;
	private String opWindow;
	private String opCctv;
	private String opVeranda;
	private String opDelivery;
	private String opFireAlarm;
	private String houseParking;
	private String houseElevator;
	private String housePet;
	private String houseContent;
	private String houseMessage;
	private double latitude;
	private double longitude;
	private int id;
	@Column(nullable = false)
	private String memberId;
	
	protected HouseVO() {

	}
}
