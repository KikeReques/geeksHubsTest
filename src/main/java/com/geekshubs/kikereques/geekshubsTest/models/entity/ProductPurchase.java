package com.geekshubs.kikereques.geekshubsTest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="compra_producto")
public class ProductPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "productoId")
    @NotEmpty
    private int productId;

    @Column(name = "compraId")
    @NotEmpty
    private int orderId;

    @Column(name = "cantidad")
    @NotEmpty
    private int amount;

    @Column(name = "total")
    @NotEmpty
    private float total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    private static final long serialVersionUID = 1L;
}
