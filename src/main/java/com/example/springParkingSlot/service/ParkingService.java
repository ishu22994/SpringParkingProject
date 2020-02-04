package com.example.springParkingSlot.service;

import com.example.springParkingSlot.dto.ParkingDetailsDTO;
import com.example.springParkingSlot.dto.UserDTO;
import com.example.springParkingSlot.entity.ParkingLevel;
import com.example.springParkingSlot.entity.ParkingLot;
import com.example.springParkingSlot.entity.ParkingSpot;

public interface ParkingService {
    ParkingLevel addParkingLevel(ParkingLevel parkingLevel);

    ParkingLot addParkingLot(ParkingLot parkingLot);

    ParkingSpot addParkingSpot(ParkingSpot parkingSpot);

   ParkingDetailsDTO getParkingDetails(UserDTO userDTO);

    double totalEarning();
}
