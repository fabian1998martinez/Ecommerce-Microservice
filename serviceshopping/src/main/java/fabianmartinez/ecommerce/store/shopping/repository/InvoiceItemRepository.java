package fabianmartinez.ecommerce.store.shopping.repository;

import fabianmartinez.ecommerce.store.shopping.entidad.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {
}
