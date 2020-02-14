package com.javaguru.shoppinglist.validation;

import com.javaguru.shoppinglist.businessLogic.Product;
import com.javaguru.shoppinglist.dataBase.DataBaseInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductValidationServiceTest {

    private DataBaseInterface db;

    private ProductAvailabilityInDatabaseValidation service;

    @Before
    public void setup() {
        db = Mockito.mock(DataBaseInterface.class);
        service = new ProductAvailabilityInDatabaseValidation(db);
    }

    @Test
    public void shouldReturnErrorWhenProductAlreadyExist() {

        Product testPoduct = new Product("milk", new BigDecimal("33"), new BigDecimal("33"));
        Product foundProduct = new Product("milk", new BigDecimal("11"), new BigDecimal("11"));
        Mockito.when(db.get("milk")).thenReturn(foundProduct);

        try {
            service.validate(testPoduct);
            fail();
        } catch (ProductFieldsValidationException e) {

            assertEquals(e.getMessage(), "In database with is a product with entered name!");
        }

        // Mockito.verify(db).delete(foundProduct);

    }

}