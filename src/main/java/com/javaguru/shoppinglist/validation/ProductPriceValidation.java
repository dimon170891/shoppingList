package com.javaguru.shoppinglist.validation;

import java.math.BigDecimal;

public class ProductPriceValidation {

    public static void validate(BigDecimal productPrice) throws ProductFieldsValidationException {

        if (productPrice.intValue() <= 0) {
            throw new ProductFieldsValidationException("Product price must be greater than 0!");
        }
    }

}
