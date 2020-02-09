package com.javaguru.shoppinglist.validation;

import com.javaguru.shoppinglist.businessLogic.Product;
import com.javaguru.shoppinglist.dataBase.DataBaseInterface;

public class ProductValidationService {

    private DataBaseInterface db;

    public ProductValidationService(DataBaseInterface db) {
        this.db = db;
    }

    public void validate(Product product) throws ProductFieldsValidationException {

        String errorText = "";


        if ((product.getName().length() < 3 || product.getName().length() > 32)) {
            errorText = errorText + "Name cannot be less than 3 characters and more than 32! \n";
        }

        if (product.getPrice().intValue() <= 0) {
            errorText = errorText + "Product price must be greater than 0! \n ";
        }

        if (product.getDiscount().intValue() < 0 || product.getDiscount().intValue() > 100) {
            errorText = errorText + "Discount cannot be more than 100 percent!  \n";
        }

        Product foundProduct = db.get(product.getName());
        if (foundProduct != null) {
            errorText = errorText + "In database with ID: " + foundProduct.getId() + " is a product with name: " + foundProduct.getName() + " ! be careful !";
        }

        if (!errorText.isEmpty()) {
            throw new ProductFieldsValidationException("  ====  ERROR === \n" + errorText);
        }
    }
}
