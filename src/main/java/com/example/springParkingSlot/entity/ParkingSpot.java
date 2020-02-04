package com.example.springParkingSlot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ParkingSpot")
public class ParkingSpot {

    @Id
    private String spotId;

    @ManyToOne
    @JoinColumn(name = "levelId")
    private ParkingLevel ParkinglevelId;

    private String type;
    private Date StartTime;

}

