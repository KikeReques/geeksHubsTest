package com.geekshubs.kikereques.geekshubsTest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="compra_producto")
public class ProductPurchase {

    @Id
    @Column(name = "compra_producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="producto_id")
    private Product product;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="compra_id")
    private Order order;

    @Column(name = "cantidad")
    @NotNull
    private int amount;

    @Column(name = "total")
    @NotNull
    private float total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
