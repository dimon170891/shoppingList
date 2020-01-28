package com.javaguru.shoppinglist.dataBase;

import com.javaguru.shoppinglist.productService.Category;
import com.javaguru.shoppinglist.productService.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataBase implements DataBaseInterface {


    private List<Product> dB = new ArrayList<>();

    @Override
    public Product get(Product insideProduct) {

        if (dB.contains(insideProduct)) {
            return dB.get(dB.indexOf(insideProduct));
        } else {
            return new Product("", new BigDecimal("0"), new BigDecimal("0"));
        }

    }

    @Override
    public Product get(String productName) {

        Predicate<Product> byName = product -> product.getName().equals(productName);
        var result = dB.stream().filter(byName).collect(Collectors.toList());
        if (!(result.size() == 0)) {
            return result.get(0);
        } else {
            return new Product("", new BigDecimal("0"), new BigDecimal("0"));
        }

    }

    public List<Product> getProductList(Category category) {

        return dB.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());

    }


    @Override
    public Product get(Long productID) {

        Predicate<Product> byId = product -> product.getId().equals(productID);
        var result = dB.stream().filter(byId).collect(Collectors.toList());
        if (!(result.size() == 0)) {
            return result.get(0);
        } else {
            return new Product("", new BigDecimal("0"), new BigDecimal("0"));
        }

    }


    @Override
    public void insert(Product product) {
        dB.add(product);
    }

    @Override
    public void update(Product product) {

        dB.set(dB.indexOf(product), product);

    }

    @Override
    public void delete(Product product) {
        dB.remove(product);
    }


    @Override
    public String toString() {
        return "DataBase{" +
                "dB=" + dB.toString() +
                '}';
    }
}
