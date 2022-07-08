package com.geekshubs.kikereques.geekshubsTest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name="compras")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "clienteId")
    @NotEmpty
    private int clientId;

    @Column(name = "fecha_compra")
    @NotEmpty
    private Date orderDate;

    @Column(name = "metodo_pago")
    @NotEmpty
    private String payMethod;

    @Column(name = "estado")
    @NotEmpty
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getBuyDate() {
        return orderDate;
    }

    public void setBuyDate(Date buyDate) {
        this.orderDate = buyDate;
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
