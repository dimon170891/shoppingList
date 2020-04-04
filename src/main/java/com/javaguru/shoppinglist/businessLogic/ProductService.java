package com.javaguru.shoppinglist.businessLogic;

import com.javaguru.shoppinglist.dataBase.DataBaseInmemory;
import com.javaguru.shoppinglist.dataBase.DataBaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductService {

    private DataBaseInterface dataBase;

    @Autowired
    public ProductService(DataBaseInmemory dataBase) {
        this.dataBase = dataBase;
    }

    public Product createProduct(String name, BigDecimal priceValue, BigDecimal discountValue) {
        Product newProduct = new Product(name, priceValue, discountValue);

        return newProduct;
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
