package com.javaguru.shoppinglist.dataBase;

import com.javaguru.shoppinglist.businessLogic.Category;
import com.javaguru.shoppinglist.businessLogic.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
@Profile("Oracle")
class DataBaseOracle implements DataBaseInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    DataBaseOracle(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Product> get(Product insideProduct) {

        String query = "select * from tasks where id=?";
        List<Product> products = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class), insideProduct.getId());
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return null;


    }

    @Override
    public Optional<Product> get(String productName) {

        String query = "select * from tasks where name =?";
        List<Product> products = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class), productName);
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();

    }

    public Optional<Product> getProductList(Category category) {
        String query = "select * from tasks where category =?";
        List<Product> products = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class), category);
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();

    }


    @Override
    public Optional<Product> get(Long productID) {

        String query = "select * from tasks where id=?";
        List<Product> products = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class), productID);
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();

    }


    @Override
    public void insert(Product product) {

        String query = "insert into product (name, description) values (" +
                "?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            return ps;
        }, keyHolder);

        product.setId(keyHolder.getKey().longValue());
        //return product;


    }

    @Override
    public void delete(Optional<Product> product) {

        String query = "delete * from tasks where id=?";
        jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class), product.get().getId());


    }


    @Override
    public void delete(Product product) {
        String query = "delete * from tasks where id=?";
        jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class), product.getId());
    }

}
