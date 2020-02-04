package com.example.springParkingSlot.repository;

import com.example.springParkingSlot.entity.ParkingSpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends CrudRepository<ParkingSpot,String> {


}
