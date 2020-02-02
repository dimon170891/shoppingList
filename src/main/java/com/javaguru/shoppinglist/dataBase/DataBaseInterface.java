package com.javaguru.shoppinglist.dataBase;

import com.javaguru.shoppinglist.businessLogic.Product;

public interface DataBaseInterface {
    void insert(Product product);


    void update(Product product);
    void delete(Product product);

    Product get(Product product);
    Product get(String productName);
    Product get(Long productID);


}
