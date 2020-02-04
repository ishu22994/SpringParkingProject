package com.example.springParkingSlot.repository;

import com.example.springParkingSlot.entity.ParkingLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLevelRepository extends CrudRepository<ParkingLevel,String> {

}
