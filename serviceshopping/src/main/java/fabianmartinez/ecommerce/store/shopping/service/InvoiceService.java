package fabianmartinez.ecommerce.store.shopping.service;

import fabianmartinez.ecommerce.store.shopping.entidad.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    public List<Invoice> findInvoiceAll();

    public Invoice createInvoice(Invoice invoice);

    public Invoice updateInvoice(Invoice invoice);

    public Invoice deleteInvoice(Invoice invoice);
    public Invoice getInvoice(Long id);

}