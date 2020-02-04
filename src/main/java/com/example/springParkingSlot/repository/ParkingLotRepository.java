package com.example.springParkingSlot.repository;

import com.example.springParkingSlot.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot,String> {

}
