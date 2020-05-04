package com.example.demo.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private double priceSum = 0;


    private List<Product> productList;

    public ProductRepository(){
        this.productList = new ArrayList<>();
    }

    public void addToList(Product product){
        productList.add(product);
    }

    public List<Product> showAll(){
        return new ArrayList<>(productList);
    }


    public String parseStringPriceToDoubleAndAddToList(Product product){
        if("".equals(product.getPrice().trim()) || null == product.getPrice()){
            return "nothing";
        }
        try{
            product.setValuePrice(Double.parseDouble(product.getPrice()));
            productList.add(product);
            priceSum += product.getValuePrice();
            return "success";
        }catch (NumberFormatException exception){
            return "numberError";
        }
    }

    public double getPriceSum(){
        return priceSum;
    }





}
