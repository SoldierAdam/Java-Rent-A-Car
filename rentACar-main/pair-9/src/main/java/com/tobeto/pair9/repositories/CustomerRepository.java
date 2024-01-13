package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsCustomerByIdentityNumber(String identityNumber);
}
