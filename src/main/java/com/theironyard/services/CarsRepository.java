package com.theironyard.services;

import com.theironyard.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cameronoakley on 11/15/15.
 */
public interface CarsRepository extends CrudRepository<Car, Integer> {
    List<Car> findByMake(String make);
    List<Car> findByDrivetype (String drivetype);
}
