package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair9.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair9.services.dtos.invoice.responses.GetListInvoiceResponse;

import java.util.List;

public interface InvoiceService {

    List<GetListInvoiceResponse> getAll();

    //GetByNumberInvoiceResponse getByNumber(int number);

    void add(AddInvoiceRequest request);

    void update(UpdateInvoiceRequest request);

    void delete(int id);

    boolean existsId(int id);

    void entryCheck(String invoiceNo,int rentalId);
}
