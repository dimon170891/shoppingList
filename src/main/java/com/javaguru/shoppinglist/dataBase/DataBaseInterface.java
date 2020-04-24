package com.javaguru.shoppinglist.dataBase;

import com.javaguru.shoppinglist.businessLogic.Category;
import com.javaguru.shoppinglist.businessLogic.Product;

import java.util.Optional;

public interface DataBaseInterface {
    void insert(Product product);

    void delete(Optional<Product> product);

    Optional<Product> getProductList(Category category);
    Optional<Product> get(Product product);
    Optional<Product> get(String productName);
    Optional<Product> get(Long productID);


    void delete(Product product);
}
