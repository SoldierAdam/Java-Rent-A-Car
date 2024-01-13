package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.Brand;
import com.tobeto.pair9.repositories.BrandRepository;
import com.tobeto.pair9.services.abstracts.BrandService;
import com.tobeto.pair9.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair9.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair9.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair9.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }

    @Override
    public List<GetListBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetListBrandResponse.class)).toList();
    }

    @Override
    public void add(AddBrandRequest request) {
        if(brandRepository.existsByName(request.getName())){
            throw new RuntimeException("There cannot be same brand");
        }
        Brand brand = this.modelMapperService.forRequest().map(request,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        if(brandRepository.existsByName(request.getName())){
            throw new RuntimeException("There cannot be same brand");
        }
        Brand brand = this.modelMapperService.forRequest().map(request,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public boolean existsId(int id) {
        return brandRepository.existsById(id);
    }
}
