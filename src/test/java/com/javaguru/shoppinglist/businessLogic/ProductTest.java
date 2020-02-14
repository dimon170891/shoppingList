package com.javaguru.shoppinglist.businessLogic;

import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest {


    @Test
    public void createProduct() {

        Product testPoduct = new Product("milk", new BigDecimal("33"), new BigDecimal("33"));

    }


}