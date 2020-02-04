package com.example.springParkingSlot.dto;

import com.example.springParkingSlot.entity.ParkingLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotDTO {

    private String spotId;
    private ParkingLevel ParkinglevelId;
    private String type;
}
