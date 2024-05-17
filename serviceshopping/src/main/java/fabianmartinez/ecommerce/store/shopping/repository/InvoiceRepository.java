package fabianmartinez.ecommerce.store.shopping.repository;

import fabianmartinez.ecommerce.store.shopping.entidad.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    public List<Invoice> findByCustomerId(Long CustomerId);
    public Invoice findByNumberInvoice(String numberInvoice);
}
