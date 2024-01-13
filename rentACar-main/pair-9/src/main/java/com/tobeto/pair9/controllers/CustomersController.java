package com.tobeto.pair9.controllers;

import com.tobeto.pair9.services.abstracts.CustomerService;
import com.tobeto.pair9.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair9.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.pair9.services.dtos.customer.responses.GetListCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<GetListCustomerResponse> getAll(){
        return customerService.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCustomerRequest request){
        customerService.add(request);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCustomerRequest request){
        this.customerService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
}
