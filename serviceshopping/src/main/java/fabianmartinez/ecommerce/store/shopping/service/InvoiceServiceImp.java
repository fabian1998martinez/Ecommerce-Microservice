package fabianmartinez.ecommerce.store.shopping.service;

import fabianmartinez.ecommerce.store.shopping.entidad.Invoice;
import fabianmartinez.ecommerce.store.shopping.repository.InvoiceItemRepository;
import fabianmartinez.ecommerce.store.shopping.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Invoice invoiceDb = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
        if(invoiceDb != null){
            return invoiceDb;
        }

        invoice.setState("CREATED");

        return  invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice  invoiceDb = getInvoice(invoice.getId());
        if(invoiceDb == null){
            return null;
        }
        invoiceDb.setCustomerId(invoice.getCustomerId());
        invoiceDb.setDescription(invoice.getDescription());
        invoiceDb.setNumberInvoice(invoice.getNumberInvoice());
        invoiceDb.getItems().clear();
        invoiceDb.setItems(invoice.getItems());
        return invoiceRepository.save(invoiceDb);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDb = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
        if(invoiceDb == null){
            return null;
        }
        invoice.setState("DELETED");

        return invoiceRepository.save(invoice);
    }
}
