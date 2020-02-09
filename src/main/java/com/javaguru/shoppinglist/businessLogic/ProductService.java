package com.javaguru.shoppinglist.businessLogic;

import com.javaguru.shoppinglist.dataBase.DataBase;
import com.javaguru.shoppinglist.validation.ProductFieldsValidationException;
import com.javaguru.shoppinglist.validation.ProductValidationService;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private DataBase dataBase;
    private ProductValidationService pvs;

    public ProductService(DataBase dataBase, ProductValidationService pvs) {
        this.dataBase = dataBase;
        this.pvs = pvs;
    }

    public Product createProduct(String name, BigDecimal priceValue, BigDecimal discountValue) {
        try {
            Product newProduct = new Product(name, priceValue, discountValue);
            pvs.validate(newProduct);
            return newProduct;
        } catch (ProductFieldsValidationException e) {
            System.out.println(e.getMessage());
            return Product.emptyProduct;
        }

    }

    public void writeProductInDataBase(Product product) {
        dataBase.insert(product);
    }

    public void setProductDescription(Product product, String productDiscription) {
        product.setDescription(productDiscription);
    }

    public void setproductCategory(Product product, Category category) {
        product.setCategory(category);
    }

    public Product getProducrFromDataBase(Long productID) {
        return dataBase.get(productID);
    }

    public Product getProducrFromDataBase(String productName) {
        return dataBase.get(productName);
    }

    public List<Product> getProducrListFromDataBaseByCategory(Category category) {
        return dataBase.getProductList(category);
    }

    public Product getProducrFromDataBase(Product product) {
        return dataBase.get(product);
    }

    public void deleteProductFromDataBase(Product product) {
        dataBase.delete(product);
    }


}
