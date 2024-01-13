package com.tobeto.pair9.entities.concretes;

import com.tobeto.pair9.entities.absracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "invoices")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity {

    @Column(name="invoice_no")
    private String invoiceNo;

    @Column(name="total_price")
    private Float totalPrice;

    @Column(name="discount_rate")
    private Float discountRate;

    @Column(name="tax_rate")
    private Float taxRate;

    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;

}
