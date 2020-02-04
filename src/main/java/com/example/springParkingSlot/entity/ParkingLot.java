package com.example.springParkingSlot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ParkingLot")
public class ParkingLot {

    @Id
   private  String parkingLotId;
   private  double longitude;
   private  double latitude;
   private  int numOfLevel;

}
