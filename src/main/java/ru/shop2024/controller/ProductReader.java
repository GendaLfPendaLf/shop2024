package ru.shop2024.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.UUID;

@Service
public class ProductReader {

    public ProductList getProducts() throws FileNotFoundException {
        try {
            Gson gson = new Gson();
            ProductList productList = gson.fromJson(new FileReader("src/main/resources/scripts/products.json"), ProductList.class);

            if (productList != null && productList.getProducts() != null) {
                for (Product product : productList.getProducts()) {
                    product.setId(UUID.randomUUID());
                    System.out.println("id: " + product.getId());
                    System.out.println("Бренд: " + product.getBrand());
                    System.out.println("Тип: " + product.getType());
                    System.out.println("Цена: " + product.getPrice());
                    System.out.println("Количество: " + product.getCount());
                    System.out.println("Описание: " + product.getDescription());
                    System.out.println();
                }
            } else {
                System.out.println("Данные из файла JSON не были успешно прочитаны или обработаны.");
            }
            return productList;
        } catch (Exception e) {
            throw e;
        }
    }
}

