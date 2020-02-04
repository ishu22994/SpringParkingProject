package com.example.springParkingSlot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDTO {

    private  String  parkingLotId;
    private  double longitude;
    private  double latitude;
    private  int numOfLevel;
}
