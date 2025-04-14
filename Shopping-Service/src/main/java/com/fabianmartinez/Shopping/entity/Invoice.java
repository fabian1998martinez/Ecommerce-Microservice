package com.fabianmartinez.Shopping.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_invoices")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_invoice")
    private String numberInvoice;

    private String description;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "invoice_id")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<InvoiceItem>  items;

    private String state;

    public Invoice(){items=new ArrayList<>();};

    @PrePersist
    public void prePersist(){this.createAt = new Date();};
}
