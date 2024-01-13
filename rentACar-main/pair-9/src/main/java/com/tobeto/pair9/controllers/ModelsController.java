package com.tobeto.pair9.controllers;

import com.tobeto.pair9.services.abstracts.ModelService;
import com.tobeto.pair9.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair9.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair9.services.dtos.model.responses.GetListModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/models")

public class ModelsController {

    private ModelService modelService;

    @GetMapping("/getAll")
    public List<GetListModelResponse> getAll(){

        return modelService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddModelRequest request){
        modelService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateModelRequest request){
        this.modelService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        modelService.delete(id);
    }


}
