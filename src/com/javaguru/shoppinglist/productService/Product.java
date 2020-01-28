package com.javaguru.shoppinglist.productService;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {


    public static final Product emptyProduct = new Product("", new BigDecimal(0), new BigDecimal(0));
    public static Long counter = 0L;
    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private BigDecimal discount;
    private String description;

    public Product(String name, BigDecimal priceValue, BigDecimal discountValue) {
        this.name = name;
        price = priceValue;
        discount = discountValue;
        id = counter.longValue() + 1;
        counter++;
        category = Category.UNSSIGNED;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(id, product.id) &&
                category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}