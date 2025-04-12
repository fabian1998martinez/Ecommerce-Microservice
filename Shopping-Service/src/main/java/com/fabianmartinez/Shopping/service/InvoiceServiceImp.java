package com.fabianmartinez.Shopping.service;

import com.fabianmartinez.Shopping.entity.Invoice;
import com.fabianmartinez.Shopping.repository.InvoiceItemRepository;
import com.fabianmartinez.Shopping.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceServiceImp implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        invoice.setState("CREATED");
        invoice.setCreateAt(new Date()); // Si querés asignar la fecha actual
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice upDateInvoice(Invoice invoice) {
        Invoice invoiceBd = getInvoice(invoice.getId());
        if (invoiceBd == null) {
            return null;
        }

        // Actualizamos solo los campos relevantes
        invoiceBd.setDescription(invoice.getDescription());
        invoiceBd.setCustomerId(invoice.getCustomerId());
        invoiceBd.setItems(invoice.getItems());

        return invoiceRepository.save(invoiceBd);
    }

    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceBd = getInvoice(invoice.getId());
        if (null == invoiceBd){
            return null;
        }
        invoiceBd.setState("DELETE");
        return invoiceRepository.save(invoiceBd);
    }
    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }
}
