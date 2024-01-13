package com.tobeto.pair9.entities.concretes;

import com.tobeto.pair9.entities.absracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "corporate_customers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CorporateCustomer extends BaseEntity {

    @Column(name="company_name")
    private String companyName;

    @Column(name="tax_no")
    private String taxNo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
