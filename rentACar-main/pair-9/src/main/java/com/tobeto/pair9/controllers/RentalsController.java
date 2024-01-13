package com.tobeto.pair9.controllers;

import com.tobeto.pair9.services.abstracts.RentalService;
import com.tobeto.pair9.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair9.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair9.services.dtos.rental.responses.GetListRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

    private RentalService rentalService;

    @GetMapping("/getAll")
    public List<GetListRentalResponse> getAll(){
        return rentalService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddRentalRequest request){
        rentalService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateRentalRequest request){
        rentalService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }
}
