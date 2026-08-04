package model;

public class Product {

    private int id;
    private String productName;
    private int categoryId;
    private String description;
    private double price;
    private String image;
    private String sellerEmail;
    private String status;


    public Product() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public String getSellerEmail() {
        return sellerEmail;
    }


    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}