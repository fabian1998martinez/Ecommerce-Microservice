package com.fabianmartinez.Shopping.controller;


import com.fabianmartinez.Shopping.entity.Invoice;
import com.fabianmartinez.Shopping.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> listAllInvoice(){

        List<Invoice> invoices = invoiceService.findInvoiceAll();
        if (invoices.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(invoices);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable("id") Long id){
        Invoice invoiceBd = invoiceService.getInvoice(id);
        if (null == invoiceBd){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(invoiceBd);

    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
        Invoice invoiceBd = invoiceService.createInvoice(invoice);
        if (invoiceBd == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceBd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> upDateInvoice(@PathVariable("id") Long id,@RequestBody Invoice invoice){

       Invoice invoiceBd = invoiceService.getInvoice(id);

        if (null == invoiceBd){
            return ResponseEntity.notFound().build();

        }
        invoice.setId(id);
        invoiceBd = invoiceService.upDateInvoice(invoice);
        return ResponseEntity.ok(invoiceBd);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable("id") Long id){
        Invoice invoiceBd = invoiceService.getInvoice(id);
        if (null==invoiceBd){
            return ResponseEntity.notFound().build();
        }
        invoiceBd = invoiceService.deleteInvoice(invoiceBd);
        return ResponseEntity.ok(invoiceBd);

    }
}
