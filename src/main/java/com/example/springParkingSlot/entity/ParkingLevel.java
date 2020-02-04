package com.example.springParkingSlot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ParkingLevel")
public class ParkingLevel {

    @Id
    private String  levelId;

    @ManyToOne
    @JoinColumn(name = "parkingLotId")
    private ParkingLot parkingLotId;

    private int numOfSlotBike;
    private int numOfSlotCar;

}
