package com.example.springParkingSlot.dto;

import com.example.springParkingSlot.entity.ParkingLevel;
import com.example.springParkingSlot.entity.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLevelDTO {

    private String  levelId;
    private ParkingLot parkingLotId;
    private int numOfSlotBike;
    private int numOfSlotCar;

}
