package com.tobeto.pair9.services.dtos.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListInvoiceResponse {

    private int id;

    private String invoiceNo;

    private Float totalPrice;

    private Float discountRate;

    private Float taxRate;
}
