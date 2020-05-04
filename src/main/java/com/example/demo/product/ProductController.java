package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    String getProducts(Model model) {
        List<Product> products = productRepository.showAll();
        model.addAttribute("products", products);
        return "productsList";
    }

    @GetMapping
    String addForm(Model model) {
        model.addAttribute("product", new Product());

        return "addProduct";
    }

    @PostMapping("/addProd")
    String addProd(Product product) {
        return productRepository.parseStringPriceToDoubleAndAddToList(product);
    }

    @GetMapping("/productsList")
    String productsList(Model model) {
        modelAdd(model);
        return "productsList";

    }

    @GetMapping("/table")
    String table(Model model) {
        modelAdd(model);
        return "table";
    }

    private void modelAdd(Model model) {
        model.addAttribute("productsList", productRepository.showAll());
        model.addAttribute("priceSum", productRepository.getPriceSum());
    }


}
