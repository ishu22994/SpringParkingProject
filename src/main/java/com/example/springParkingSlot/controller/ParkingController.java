package com.example.springParkingSlot.controller;

import com.example.springParkingSlot.dto.*;
import com.example.springParkingSlot.entity.ParkingLevel;
import com.example.springParkingSlot.entity.ParkingLot;
import com.example.springParkingSlot.entity.ParkingSpot;
import com.example.springParkingSlot.service.ParkingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;

@RequestMapping("/parking")
@RestController
public class ParkingController {

   @Autowired
   ParkingService parkingService;

   @PostMapping("/addParkingLevel")
   public ResponseEntity<ParkingLevel> addParkingLevel(@RequestBody ParkingLevelDTO parkingLevelDTO){

       ParkingLevel parkingLevel = new ParkingLevel();
        BeanUtils.copyProperties(parkingLevelDTO,parkingLevel);
        parkingService.addParkingLevel(parkingLevel);
        return new ResponseEntity<ParkingLevel>(parkingLevel,HttpStatus.OK);
    }


    @PostMapping("/addParkingLot")
    public ResponseEntity<ParkingLot> addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO){

        ParkingLot parkingLot = new ParkingLot();
        BeanUtils.copyProperties(parkingLotDTO,parkingLot);
        parkingService.addParkingLot(parkingLot);
        return new ResponseEntity<ParkingLot>(parkingLot,HttpStatus.OK);
    }

    @PostMapping("/addParkingSpot")
    public ResponseEntity<ParkingSpot> addParkingSpot(@RequestBody ParkingSpotDTO parkingSpotDTO){

        ParkingSpot parkingSpot = new ParkingSpot();
        BeanUtils.copyProperties(parkingSpotDTO,parkingSpot);
        Date startTime = new Date();
        parkingSpot.setStartTime(startTime);
        ParkingSpot parkingSpot1=parkingService.addParkingSpot(parkingSpot);
        return new ResponseEntity<ParkingSpot>(parkingSpot1,HttpStatus.OK);
    }


    @GetMapping("/getNearestParkingDetails")
    public ResponseEntity<ParkingDetailsDTO> getParkingDetails(@RequestBody UserDTO userDTO){

       ParkingDetailsDTO parkingDetailsDTO = parkingService.getParkingDetails(userDTO);

        return new ResponseEntity<ParkingDetailsDTO>(parkingDetailsDTO,HttpStatus.OK);

    }

    @GetMapping("/totalEarning")
    public double totalEarning(){
       double earning = parkingService.totalEarning();
       return earning;
    }


}
