package com.javaguru.shoppinglist.validation;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidation {

    public static void validate(BigDecimal productPrice) throws ProductFieldsValidationException {

        if (productPrice.intValue() <= 0) {
            throw new ProductFieldsValidationException("Product price must be greater than 0!");
        }
    }

}
