package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.CorporateCustomer;
import com.tobeto.pair9.repositories.CorporateCustomerRepository;
import com.tobeto.pair9.services.abstracts.CorporateCustomerService;
import com.tobeto.pair9.services.abstracts.UserService;
import com.tobeto.pair9.services.dtos.corporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair9.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair9.services.dtos.corporateCustomer.responses.GetListCorporateCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final UserService userService;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetListCorporateCustomerResponse> getAll() {
        List<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();
        return corporateCustomers.stream().map(corporateCustomer -> this.modelMapperService.forResponse()
                .map(corporateCustomer, GetListCorporateCustomerResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(AddCorporateCustomerRequest request) {
        entryCheck(request.getCompanyName(),request.getTaxNo(),request.getUserId());
        CorporateCustomer corporateCustomer=this.modelMapperService.forRequest()
                .map(request,CorporateCustomer.class);
        this.corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void update(UpdateCorporateCustomerRequest request) {
        entryCheck(request.getCompanyName(), request.getTaxNo(),request.getUserId());
        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest()
                .map(request,CorporateCustomer.class);
        this.corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void delete(int id) {
        this.corporateCustomerRepository.deleteById(id);
    }

    @Override
    public void entryCheck(String companyName, String taxNo,int userId) {
        if(corporateCustomerRepository.existsByCompanyName(companyName)){
            throw new RuntimeException("There cannot be same companyName");
        }
        if(corporateCustomerRepository.existsByTaxNo(taxNo)){
            throw new RuntimeException("There cannot be same tax number");
        }
        if(!userService.existsId(userId)){
            throw new RuntimeException("There is no model in the given id!");
        }
    }
}
