package com.javaguru.shoppinglist.productService;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    public static final Product emptyProduct = new Product("", new BigDecimal(0), new BigDecimal(0));
    public static Long counter = 0L;
    private BigDecimal discount;
    private String description;
    private BigDecimal priceWithDiscount;

    public Product(String name, BigDecimal priceValue, BigDecimal discountValue) {
        this.name = name;
        price = priceValue;

        if (discountValue.longValue() > 0 && discountValue.longValue() < 100) {
            discount = discountValue;

        } else {
            discount = new BigDecimal(0);
        }
        setPriceWithDiscount();
        counter = new Long(counter.longValue() + 1);
        id = new Long(counter.longValue());
        category = Category.UNSSIGNED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
        setPriceWithDiscount();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private void setPriceWithDiscount() {

        BigDecimal procent = price.divideToIntegralValue(new BigDecimal(100));
        BigDecimal discount = procent.multiply(getDiscount());
        BigDecimal curentPrice = price.subtract(discount);
        priceWithDiscount = curentPrice;

    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
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

}