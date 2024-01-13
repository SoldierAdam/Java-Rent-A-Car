package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.Brand;
import com.tobeto.pair9.entities.concretes.Model;
import com.tobeto.pair9.repositories.ModelRepository;
import com.tobeto.pair9.services.abstracts.BrandService;
import com.tobeto.pair9.services.abstracts.ModelService;
import com.tobeto.pair9.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair9.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair9.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair9.services.dtos.model.responses.GetListModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private BrandService brandService;


    @Override
    public List<GetListModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        return models.stream().map(model -> this.modelMapperService.forResponse().map(model, GetListModelResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void add(AddModelRequest request) {
        if(modelRepository.existsByName(request.getName())){
            throw new RuntimeException("There cannot be same model");
        }
        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest request) {
        entryCheck(request.getName(),request.getBrandId());
        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }

    @Override
    public boolean existsId(int id) {
        return modelRepository.existsById(id);
    }

    @Override
    public void entryCheck(String name,int brandId) {
        if(modelRepository.existsByName(name)){
            throw new RuntimeException("There cannot be same model");
        }
        if(!brandService.existsId(brandId)){
            throw new RuntimeException("There is no brand in the given id!");
        }
    }
}
