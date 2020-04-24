package com.javaguru.shoppinglist.validation;

public class ProductValidationServiceTest {

//    private DataBaseInterface db;
//
//    private ProductAvailabilityInDatabaseValidation service;
//
//    @Before
//    public void setup() {
//        db = Mockito.mock(DataBaseInterface.class);
//        service = new ProductAvailabilityInDatabaseValidation(db);
//    }
//
//    @Test
//    public void shouldReturnErrorWhenProductAlreadyExist() {
//
//        Product testPoduct = new Product("milk", new BigDecimal("33"), new BigDecimal("33"));
//        Product foundProduct = new Product("milk", new BigDecimal("11"), new BigDecimal("11"));
//        Mockito.when(db.get("milk")).thenReturn(java.util.Optional.of(foundProduct));
//
//        try {
//            service.validate(testPoduct);
//            fail();
//        } catch (ProductFieldsValidationException e) {
//
//            assertEquals(e.getMessage(), "In database with is a product with entered name!");
//        }
//
//        // Mockito.verify(db).delete(foundProduct);
//
//    }

}