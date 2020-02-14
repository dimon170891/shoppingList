package com.javaguru.shoppinglist.validation;

public class ProductNameLengthValidation {

    public static void validate(String productName) throws ProductFieldsValidationException {

        if ((productName.length() < 3 || productName.length() > 32)) {
            throw new ProductFieldsValidationException("Name cannot be less than 3 characters and more than 32!");
        }
    }
}
