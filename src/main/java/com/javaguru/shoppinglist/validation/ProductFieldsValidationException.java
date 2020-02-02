package com.javaguru.shoppinglist.validation;


public class ProductFieldsValidationException extends RuntimeException {

    ProductFieldsValidationException(String errorDescription) {
        super(errorDescription);
    }

}
