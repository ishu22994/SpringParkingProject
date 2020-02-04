package com.example.springParkingSlot.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDetailsDTO {

    private String parkingLotId;
    private String levelId;
    private int numOfSpots;
}
