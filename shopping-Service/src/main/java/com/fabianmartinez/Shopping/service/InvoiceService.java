package com.fabianmartinez.Shopping.service;

import com.fabianmartinez.Shopping.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    public Invoice getInvoice(Long id);
    public List<Invoice> findInvoiceAll();
    public Invoice createInvoice(Invoice invoice);
    public Invoice upDateInvoice(Invoice invoice);
    public Invoice deleteInvoice(Invoice invoice);

}
