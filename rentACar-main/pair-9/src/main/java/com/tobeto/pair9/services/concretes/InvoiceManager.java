package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.Invoice;
import com.tobeto.pair9.repositories.InvoiceRepository;
import com.tobeto.pair9.services.abstracts.InvoiceService;
import com.tobeto.pair9.services.abstracts.RentalService;
import com.tobeto.pair9.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair9.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair9.services.dtos.invoice.responses.GetListInvoiceResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService modelMapperService;
    private final RentalService rentalService;

    @Override
    public List<GetListInvoiceResponse> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream()
                .map(invoice -> this.modelMapperService.forResponse()
                        .map(invoice,GetListInvoiceResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(AddInvoiceRequest request) {
        entryCheck(request.getInvoiceNo(), request.getRentalId());
        Invoice invoice = this.modelMapperService.forRequest().map(request, Invoice.class);
        this.invoiceRepository.save(invoice);
    }

    @Override
    public void update(UpdateInvoiceRequest request) {
        entryCheck(request.getInvoiceNo(),request.getRentalId());
        Invoice invoice = this.modelMapperService.forRequest()
                .map(request,Invoice.class);
        this.invoiceRepository.save(invoice);
    }

    @Override
    public void delete(int id) {
        this.invoiceRepository.deleteById(id);
    }

    @Override
    public boolean existsId(int id) {
        return invoiceRepository.existsById(id);
    }

    @Override
    public void entryCheck(String invoiceNo, int rentalId) {
        if(invoiceRepository.existsInvoiceByInvoiceNo(invoiceNo)){
            throw new RuntimeException("There cannot be two invoice with the same invoice number");
        }
        if(!rentalService.existsId(rentalId)){
            throw new RuntimeException("There is no rental in the given id!");
        }
    }
}
