package com.example.springParkingSlot.service.Impl;

import com.example.springParkingSlot.dto.ParkingDetailsDTO;
import com.example.springParkingSlot.dto.UserDTO;
import com.example.springParkingSlot.entity.ParkingLevel;
import com.example.springParkingSlot.entity.ParkingLot;
import com.example.springParkingSlot.entity.ParkingSpot;
import com.example.springParkingSlot.repository.ParkingLevelRepository;
import com.example.springParkingSlot.repository.ParkingLotRepository;
import com.example.springParkingSlot.repository.ParkingSpotRepository;
import com.example.springParkingSlot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {


    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    ParkingLevelRepository parkingLevelRepository;

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Override
    public ParkingLevel addParkingLevel(ParkingLevel parkingLevel) {
        return parkingLevelRepository.save(parkingLevel);
    }

    @Override
    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingSpot addParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    @Override
    public ParkingDetailsDTO getParkingDetails(UserDTO userDTO) {

        ParkingDetailsDTO parkingDetailsDTO = new ParkingDetailsDTO();
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots = (ArrayList<ParkingLot>)parkingLotRepository.findAll();

        double min = Integer.MAX_VALUE;
        String parkingLotId = null;
        for(ParkingLot parkingLot : parkingLots){
            double value = Math.pow(userDTO.getLatitude() - parkingLot.getLatitude(),2) + Math.pow(userDTO.getLongitude() - parkingLot.getLongitude(),2);
            double distance = Math.sqrt(value);
            if(distance < min){
                min=distance;
                parkingLotId = parkingLot.getParkingLotId();
            }
        }

        parkingDetailsDTO.setParkingLotId(parkingLotId);
        final String parkingId=parkingLotId;

        List<ParkingLevel> parkingLevels = (ArrayList<ParkingLevel>)parkingLevelRepository.findAll();
        String levelId = null;
        parkingLevels=(ArrayList<ParkingLevel>) parkingLevels.stream().filter(parkingLevel ->
        parkingLevel.getParkingLotId().getParkingLotId().equals(parkingId)).collect(Collectors.toList());
        int numOfSpots = 0;

        for(ParkingLevel parkingLevel:parkingLevels){

            if(userDTO.getType()=="Car"){

                if(parkingLevel.getNumOfSlotCar() > 0){

                    numOfSpots = parkingLevel.getNumOfSlotCar();
                    levelId = parkingLevel.getLevelId();
                    break;

                }

            }else
            {if(parkingLevel.getNumOfSlotBike() > 0){

                numOfSpots = parkingLevel.getNumOfSlotBike();
                levelId = parkingLevel.getLevelId();
                break;

            }
            }

        }
        parkingDetailsDTO.setLevelId(levelId);
        parkingDetailsDTO.setNumOfSpots(numOfSpots);
        Date startTime = new Date();

        return parkingDetailsDTO;
    }

    @Override
    public double totalEarning() {
        double earning = 0;
        Date EndTime = new Date();
       List<ParkingSpot> parkingSpots = (ArrayList<ParkingSpot>)parkingSpotRepository.findAll();
       for (ParkingSpot parkingSpot : parkingSpots){

           long diff = EndTime.getTime() - parkingSpot.getStartTime().getTime();
           long diffMinutes = diff / (60 * 1000) % 60;
           earning += (diffMinutes*10);

       }

        return earning;
    }


}
