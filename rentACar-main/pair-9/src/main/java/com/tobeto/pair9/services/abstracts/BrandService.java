package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair9.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair9.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair9.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {

    GetByIdBrandResponse getById(int id);

    List<GetListBrandResponse> getAll();

    void add(AddBrandRequest request);

    void update(UpdateBrandRequest request);

    void delete(int id);

    boolean existsId(int id);

}
