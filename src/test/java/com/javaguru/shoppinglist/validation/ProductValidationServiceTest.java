package com.javaguru.shoppinglist.validation;

import com.javaguru.shoppinglist.businessLogic.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductValidationServiceTest {

    @Test
    public void test1() {

        Product testPoduct = new Product("qw", new BigDecimal("33"), new BigDecimal("33"));
        try {
            ProductValidationService ps = new ProductValidationService();
            ps.validate(testPoduct);
            fail();
        } catch (ProductFieldsValidationException e) {

            assertEquals(e.getMessage(), "  ====  ERROR === \n" +
                    "Name cannot be less than 3 characters and more than 32! \n");
        }
    }

}