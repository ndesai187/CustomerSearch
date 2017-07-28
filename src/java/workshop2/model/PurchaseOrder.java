package workshop2.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "PURCHASE_ORDER")
public class PurchaseOrder implements Serializable{
    
    @Id
    @Column(name = "order_num")
    private int orderNumber;
    
    @Column(name = "product_id")    
    private int productId;
    private int quantity;
    
    @Column(name = "shipping_cost")    
    private float shippingCost;
    
    @Column(name = "sales_date")   
    @Temporal(TemporalType.DATE)    
    private Date salesDate;
    
    @Column(name = "shipping_date")    
    @Temporal(TemporalType.DATE)
    private Date shippingDate;
    
    @Column(name = "freight_company")
    private String freight;
    
    @ManyToOne 
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
