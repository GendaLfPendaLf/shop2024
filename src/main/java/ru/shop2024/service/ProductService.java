package ru.shop2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shop2024.controller.ProductList;
import ru.shop2024.controller.ProductReader;

import java.io.FileNotFoundException;
import java.util.UUID;

@Service
public class ProductService {
    private ProductList productList;

    @Autowired
    public ProductService(ProductReader productReader) throws FileNotFoundException {
        this.productList = productReader.getProducts();
    }

    public ProductList getProducts() {
        return productList;
    }

    public void deleteProduct(UUID productId) {

    }
}
