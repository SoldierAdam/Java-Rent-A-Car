package com.tobeto.pair9.controllers;

import com.tobeto.pair9.services.abstracts.CorporateCustomerService;
import com.tobeto.pair9.services.dtos.corporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair9.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair9.services.dtos.corporateCustomer.responses.GetListCorporateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/corporateCustomers")
public class CorporateCustomersController {

    private CorporateCustomerService corporateCustomerService;

    @GetMapping("/getAll")
    public List<GetListCorporateCustomerResponse> getAll(){
        return corporateCustomerService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCorporateCustomerRequest request){
        corporateCustomerService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCorporateCustomerRequest request){
        this.corporateCustomerService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        corporateCustomerService.delete(id);
    }


}
