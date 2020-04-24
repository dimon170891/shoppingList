package com.javaguru.shoppinglist.dataBase;

import com.javaguru.shoppinglist.businessLogic.Category;
import com.javaguru.shoppinglist.businessLogic.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@Profile("inmemory")
public class DataBaseInmemory implements DataBaseInterface {

    private List<Product> dB = new ArrayList<>();
    private Long taskIdSequence = 0L;

    @Override
    public Optional<Product> get(Product insideProduct) {

        if (dB.contains(insideProduct)) {
            return Optional.ofNullable(dB.get(dB.indexOf(insideProduct)));
        } else {
            // return Product.emptyProduct;
            return null;
        }

    }

    @Override
    public Optional<Product> get(String productName) {

        Predicate<Product> byName = product -> product.getName().equals(productName);

        List<Product> result = dB.stream().filter(byName).collect(Collectors.toList());
        if (!(result.size() == 0)) {
            return Optional.ofNullable(result.get(0));
        } else {
            //return Product.emptyProduct;
            return Optional.empty();
        }

    }

    public Optional<Product> getProductList(Category category) {

        List<Product> products = dB.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
        return (Optional<Product>) Optional.ofNullable(products.get(0));

    }


    @Override
    public Optional<Product> get(Long productID) {

        Predicate<Product> byId = product -> product.getId().equals(productID);
        var result = dB.stream().filter(byId).collect(Collectors.toList());
        if (!(result.size() == 0)) {
            return Optional.ofNullable(result.get(0));
        } else {
            //return Product.emptyProduct;
            return Optional.empty();
        }

    }


    @Override
    public void insert(Product product) {
        product.setId(taskIdSequence++);
        dB.add(product);
    }

    @Override
    public void delete(Optional<Product> product) {
        dB.remove(product);
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
