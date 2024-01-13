package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.Car;
import com.tobeto.pair9.repositories.CarRepository;
import com.tobeto.pair9.services.abstracts.CarService;
import com.tobeto.pair9.services.abstracts.ColorService;
import com.tobeto.pair9.services.abstracts.ModelService;
import com.tobeto.pair9.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair9.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair9.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair9.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelService modelService;
    private ColorService colorService;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetListCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car->this.modelMapperService.forResponse()
                        .map(car, GetListCarResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse()
                .map(car, GetByIdCarResponse.class);
    }


    @Override
    public void add(AddCarRequest request) {
        entryCheck(request.getPlate(), request.getModelId(), request.getColorId());
        Car car = this.modelMapperService.forRequest().map(request, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        entryCheck(request.getPlate(), request.getModelId(), request.getColorId());
        Car car = this.modelMapperService.forRequest()
                .map(request,Car.class);
        this.carRepository.save(car);
    }

    public boolean existsId(int id) {
        return carRepository.existsById(id);
    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);
    }

    public void entryCheck(String plate, int modelId, int colorId){
        if (carRepository.existsCarByPlate(plate))
            throw  new RuntimeException("There cannot be two vehicles with the same license plate!");
        if (!modelService.existsId(modelId))
            throw new RuntimeException("There is no model in the given id!");
        if (!colorService.existsId(colorId))
            throw new RuntimeException("There is no color in the given id!");
    }
}
