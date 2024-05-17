package fabianmartinez.ecommerce.store.shopping.entidad;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private Double quantity;
    private double price;

    @Transient
    private double subTotal;

    public double getSubTotal(){
        if(this.price>0&&this.quantity >0){
           return this.quantity = this.price;
        }else {
            return 0;
        }
    }

}
