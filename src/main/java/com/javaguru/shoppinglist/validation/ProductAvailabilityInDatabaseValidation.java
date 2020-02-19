package com.javaguru.shoppinglist.validation;

import com.javaguru.shoppinglist.businessLogic.Product;
import com.javaguru.shoppinglist.dataBase.DataBaseInterface;
import org.springframework.stereotype.Component;

@Component
public class ProductAvailabilityInDatabaseValidation {

    private DataBaseInterface db;

    public ProductAvailabilityInDatabaseValidation(DataBaseInterface db) {
        this.db = db;
    }

    public boolean validate(Product product) throws ProductFieldsValidationException {

        if (product == null) {
            throw new ProductFieldsValidationException("received data == null ");
        }
        Product foundProduct = db.get(product.getName());
        if (foundProduct != null) {
            throw new ProductFieldsValidationException("In database with is a product with entered name!");

        }

        return true;

    }


}
