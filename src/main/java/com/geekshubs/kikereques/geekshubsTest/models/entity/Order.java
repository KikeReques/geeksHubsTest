package com.geekshubs.kikereques.geekshubsTest.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="compras")
public class Order {

    @Id
    @Column(name = "compra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private Client client;

    @Column(name = "fecha_compra")
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date orderDate;

    @Column(name = "metodo_pago")
    @NotEmpty
    private String payMethod;

    @Column(name = "estado")
    @NotEmpty
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private static final long serialVersionUID = 1L;
}
