package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair9.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair9.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair9.services.dtos.car.responses.GetListCarResponse;
import com.tobeto.pair9.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair9.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair9.services.dtos.rental.responses.GetListRentalResponse;

import java.util.List;

public interface RentalService {

    List<GetListRentalResponse> getAll();

    void add(AddRentalRequest request);

    void update(UpdateRentalRequest request);

    void delete(int id);

    boolean existsId(int id);

    void entryCheck(int carId, int userId);
}
