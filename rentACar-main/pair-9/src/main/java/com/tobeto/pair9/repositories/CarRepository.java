package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Car;
import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsCarByPlate (String plate);
}
