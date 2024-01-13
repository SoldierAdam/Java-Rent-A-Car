package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.Customer;
import com.tobeto.pair9.repositories.CustomerRepository;
import com.tobeto.pair9.services.abstracts.CustomerService;
import com.tobeto.pair9.services.abstracts.UserService;
import com.tobeto.pair9.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair9.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.pair9.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;
    private final UserService userService;

    @Override
    public List<GetListCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer,GetListCustomerResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(AddCustomerRequest request) {
        entryCheck(request.getIdentityNumber(),request.getUserId());
        Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        entryCheck(request.getIdentityNumber(),request.getUserId());
        Customer customer = this.modelMapperService.forRequest()
                .map(request,Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public boolean existsId(int id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void entryCheck(String identityNumber, int userId) {
        if(customerRepository.existsCustomerByIdentityNumber(identityNumber)){
            throw new RuntimeException("There cannot be two customer with the same identity number");
        }
        if(!userService.existsId(userId)){
            throw new RuntimeException("There is no user in the given id!");
        }
    }
}
