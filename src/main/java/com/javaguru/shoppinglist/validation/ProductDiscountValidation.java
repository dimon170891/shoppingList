package com.javaguru.shoppinglist.validation;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidation {


    public static void validate(BigDecimal productDiscount) throws ProductFieldsValidationException {

        if (productDiscount.intValue() < 0 || productDiscount.intValue() > 100) {
            throw new ProductFieldsValidationException("Discount cannot be more than 100 percent!");
        }

    }

}
