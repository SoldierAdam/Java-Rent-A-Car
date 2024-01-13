package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {


    boolean existsInvoiceByInvoiceNo(String invoiceNo);



}


//double dailyPrice = carService.getById(request.getCarId()).getDailyPrice();
//    rental.setTotal_price(daysBetween * dailyPrice);