package com.fabianmartinez.Shopping.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_invoice_items")
public class InvoiceItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "la cantidad debe ser mayor a cero")
    private Double quantity;
    private Double price;

    @Column(name = "product_id")
    private Long productId;

    @Transient
    private Double subToTal;

    public Double getSubTotal(){
      if (this.price >=0 && quantity >=0){
          return this.price * this.quantity;
      } else {
          return (double) 0;
      }
    };
}
