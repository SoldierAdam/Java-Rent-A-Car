package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.pair9.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.pair9.services.dtos.customer.responses.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetListCustomerResponse> getAll();

    void add(AddCustomerRequest request);

    void update(UpdateCustomerRequest request);

    void delete(int id);

    boolean existsId(int id);

    void entryCheck(String identityNumber, int userId);

}
