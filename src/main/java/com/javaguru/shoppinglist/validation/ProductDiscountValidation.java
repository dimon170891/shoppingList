package com.javaguru.shoppinglist.validation;

import java.math.BigDecimal;

public class ProductDiscountValidation {


    public static void validate(BigDecimal productDiscount) throws ProductFieldsValidationException {

        if (productDiscount.intValue() < 0 || productDiscount.intValue() > 100) {
            throw new ProductFieldsValidationException("Discount cannot be more than 100 percent!");
        }

    }

}
