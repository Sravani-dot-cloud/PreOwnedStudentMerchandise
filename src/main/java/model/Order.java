package model;

import java.sql.Timestamp;

public class Order {

    private int id;
    private String buyerEmail;
    private int productId;
    private Timestamp orderDate;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getBuyerEmail() {
        return buyerEmail;
    }


    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }


    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }


    public Timestamp getOrderDate() {
        return orderDate;
    }


    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}