package com.javaguru.shoppinglist.businessLogic;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product {

   // public static Long counter = 0L;
    // public static final Product emptyProduct = new Product("", new BigDecimal(0), new BigDecimal(0));
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category")
    private Category category;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "description")
    private String description;

    public Product(String name, BigDecimal priceValue, BigDecimal discountValue) {
        this.name = name;
        price = priceValue;
        discount = discountValue;
       // id = counter.longValue();
      //  counter++;
        category = Category.UNSSIGNED;

    }

    public Product() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
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