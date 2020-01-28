package com.javaguru.shoppinglist.validation;

import com.javaguru.shoppinglist.businessLogic.Product;
import com.javaguru.shoppinglist.businessLogic.ProductService;

public class ProductValidationService {

    public void validate(Product product) throws ProductFieldsValidationException {

        String errorText = "";


        if ((product.getName().length() < 3 || product.getName().length() > 32)) {
            errorText = errorText + "Name cannot be less than 3 characters and more than 32! \n";
        }

        if (product.getPrice().intValue() <= 0) {
            errorText = errorText + "Product price must be greater than 0! \n ";
        }

        if (product.getDiscount().intValue() < 0 || product.getDiscount().intValue() > 100) {
            errorText = errorText + "Discount cannot be more than 100 percent!  \n";
        }


        ProductService productService = new ProductService();
        Product foundProduct = productService.getProducrFromDataBase(product.getName());
        if (!(foundProduct == Product.emptyProduct)) {
            errorText = errorText + "In database with ID: " + foundProduct.getId() + " is a product with name: " + foundProduct.getName() + " ! be careful !";
        }

        if (!errorText.isEmpty()) {
            throw new ProductFieldsValidationException("  ====  ERROR === \n" + errorText);
        }
    }
}
