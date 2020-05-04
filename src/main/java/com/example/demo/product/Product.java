package com.example.demo.product;

public class Product {

    private String name;
    private String price;
    private double valuePrice;

    public Product(){}

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }


    public double getValuePrice() {
        return valuePrice;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setValuePrice(double valuePrice) {
        this.valuePrice = valuePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
