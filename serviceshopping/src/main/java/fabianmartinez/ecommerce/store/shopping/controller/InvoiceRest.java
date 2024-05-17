package fabianmartinez.ecommerce.store.shopping.controller;


import fabianmartinez.ecommerce.store.shopping.entidad.Invoice;
import fabianmartinez.ecommerce.store.shopping.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/invoices")
public class InvoiceRest {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> listAllInvoice() {

        List<Invoice> invoices = invoiceService.findInvoiceAll();
        if(invoices.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(invoices);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable("id") Long id){
        log.info("Fetching Invoice with id{}",id);
          Invoice invoiceDb = invoiceService.getInvoice(id);
          if(null==invoiceDb){
              log.error("Fetching Invoice id{} no found.",id);
              return  ResponseEntity.noContent().build();
          }
          return ResponseEntity.ok(invoiceDb);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable(value = "id") Long id, @RequestBody Invoice invoice){
      log.info("updating Invoice witch id{}",id);
        invoice.setId(id);
        Invoice currenInvoice = invoiceService.updateInvoice(invoice);

        if(null == currenInvoice){
            log.error("updating Invoice witch id{},not found",id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(currenInvoice);
    }


    @PostMapping(value = "/{id}")
    public ResponseEntity<Invoice> createInvoice(@PathVariable(value = "id") Long id , @RequestBody Invoice invoice){
        invoice.setId(id);
        Invoice currenInvoice = invoiceService.createInvoice(invoice);
        if(currenInvoice==null){
          return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(invoice);
    }

    public ResponseEntity<Invoice> deleteInvoice(@PathVariable(value = "id") Long id){
        Invoice invoiceDb = invoiceService.getInvoice(id);
        if(null==invoiceDb){
            return ResponseEntity.noContent().build();
        }
        invoiceDb.setState("DELETED");

        return ResponseEntity.ok(invoiceDb);
    }

}