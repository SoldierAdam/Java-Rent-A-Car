package com.tobeto.pair9.controllers;

import com.tobeto.pair9.services.abstracts.BrandService;
import com.tobeto.pair9.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair9.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair9.services.dtos.brand.responses.GetListBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    @GetMapping("/getAll")
    public List<GetListBrandResponse> getAll(){
        return brandService.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddBrandRequest request){
        brandService.add(request);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateBrandRequest request){
        this.brandService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }


}
