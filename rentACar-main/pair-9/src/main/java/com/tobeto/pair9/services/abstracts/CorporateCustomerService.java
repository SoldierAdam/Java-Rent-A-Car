package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.services.dtos.corporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair9.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair9.services.dtos.corporateCustomer.responses.GetListCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {

    List<GetListCorporateCustomerResponse> getAll();

    void add(AddCorporateCustomerRequest request);

    void update(UpdateCorporateCustomerRequest request);

    void delete(int id);

    void entryCheck(String companyName, String taxNo,int userId);
}
