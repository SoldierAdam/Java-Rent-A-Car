package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.entities.concretes.Car;
import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair9.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair9.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair9.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarService{

    List<GetListCarResponse> getAll();

    GetByIdCarResponse getById(int id);

    void add(AddCarRequest request);

    void update(UpdateCarRequest request);

    void delete(int id);

    boolean existsId(int id);

    void entryCheck(String plate, int modelId, int colorId);
}
