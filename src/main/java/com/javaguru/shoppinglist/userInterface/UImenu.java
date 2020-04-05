package com.javaguru.shoppinglist.userInterface;

import com.javaguru.shoppinglist.businessLogic.Category;
import com.javaguru.shoppinglist.businessLogic.Product;
import com.javaguru.shoppinglist.businessLogic.ProductService;
import com.javaguru.shoppinglist.validation.ProductDiscountValidation;
import com.javaguru.shoppinglist.validation.ProductFieldsValidationException;
import com.javaguru.shoppinglist.validation.ProductNameLengthValidation;
import com.javaguru.shoppinglist.validation.ProductPriceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class UImenu {

    private static ProductService productService;
    private static KeyboardInput keyboardInput;

    @Autowired
    public UImenu(ProductService productService, KeyboardInput keyboardInput) {
        this.productService = productService;
        this.keyboardInput = keyboardInput;

    }

    private static Category getCategoryByMenu() {
        Category category = Category.UNSSIGNED;
        MenuNotification.checkingCategoryText();
        Category.printCategoryList();

        int userChose = keyboardInput.getUserNumberInput();
        if (userChose < Category.getCategoryList().size()) {
            category = (Category) Category.getCategoryList().get(userChose);
        }
        return category;
    }

    private void createNewProduct() {

        String name = getProductName();
        BigDecimal priceBD = getProductPrice();
        BigDecimal discount = getProductDiscount();

        Product newProduct = productService.createProduct(name, priceBD, discount);
        productService.writeProductInDataBase(newProduct);

        //if (!(newProduct == Product.emptyProduct)) {
        if (!(newProduct == null)) {
            setCategory(productService, newProduct);
            setDescription(newProduct);
            System.out.println("======   You created product : ");
            System.out.println(newProduct.toString());
        }
    }

    private BigDecimal getProductDiscount() {
        BigDecimal discount = new BigDecimal("0");

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("======   Please enter product discount  in format like 0.00. Discount cannot be more than 100 percent!");
                discount = keyboardInput.getKeyboardInputBigDecimal();

                ProductDiscountValidation.validate(discount);
                correctInput = true;
            } catch (ProductFieldsValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return discount;
    }

    private BigDecimal getProductPrice() {
        BigDecimal priceBD = new BigDecimal("0");

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("======   Please enter product pice in format like 0.00 ! Product price must be greater than 0! ");
                priceBD = keyboardInput.getKeyboardInputBigDecimal();
                ProductPriceValidation.validate(priceBD);
                correctInput = true;
            } catch (ProductFieldsValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return priceBD;
    }

    private String getProductName() {
        String name = "";

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("======   Please enter product name! Name cannot be less than 3 characters and more than 32! ");
                name = keyboardInput.getKeyboardInputLine();
                ProductNameLengthValidation.validate(name);
                correctInput = true;
            } catch (ProductFieldsValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return name;
    }

    private void setDescription(Product product) {

        MenuNotification.descriptionTextQuestion();

        int userChose = keyboardInput.getUserNumberInput();
        if (userChose > 0) {
            setProductDescription(product);
        }

    }

    private void setCategory(ProductService productService, Product product) {

        MenuNotification.settingCategoryTextQuestion();


        int userChose = keyboardInput.getUserNumberInput();
        if (userChose > 0) {
            Category category = getCategoryByMenu();
            productService.setproductCategory(product, category);
        }

    }

    private void setProductDescription(Product product) {

        MenuNotification.descriptionTextSetting();

        String description = keyboardInput.getKeyboardInputLine();
        productService.setProductDescription(product, description);

    }

    private void getProductInformation() {

        Optional<Product> receivedProduct = getProductAcrossMenue();

        // if (!(receivedProduct == Product.emptyProduct)) {
        if (!(receivedProduct == null)) {
            System.out.println(receivedProduct.toString());
        } else {
            System.out.println("Product dont search!");
        }

    }

    private Optional<Product> getProductAcrossMenue() {

        Optional<Product> receivedProduct;
        MenuNotification.gettingProductTextQuestion();


        int userChose = keyboardInput.getUserNumberInput();
        if (userChose == 1) {
            System.out.println("enter product ID to search ");
            Long iD = new Long(keyboardInput.getUserNumberInput());

            receivedProduct = productService.getProducrFromDataBase(iD);
        } else {
            System.out.println("enter product name to search ");
            String productName = keyboardInput.getKeyboardInputLine();
            receivedProduct = productService.getProducrFromDataBase(productName);
        }
        return receivedProduct;
    }

    private void deleteSelectedProduct() {
        MenuNotification.productSelectingToDeleteText();
        Optional<Product> productToDelete = getProductAcrossMenue();

        //if (!(productToDelete == Product.emptyProduct)) {
        if (!(productToDelete == null)) {
            productService.deleteProductFromDataBase(productToDelete);
            System.out.println("Product " + productToDelete.toString() + "deleted");
        } else {
            System.out.println("Dont searched product");
        }

    }

    private void getProductListByCategory() {
        Category category = getCategoryByMenu();
        List<Product> productList = productService.getProducrListFromDataBaseByCategory(category);
        System.out.println(productList.toString());
    }

    public void mainUserMenu() {
        int userMenuChose = 1;
        while (userMenuChose >= 1 && userMenuChose <= 4) {
            MenuNotification.userMenu();

            userMenuChose = keyboardInput.getUserNumberInput();

            if (userMenuChose == 1) {
                createNewProduct();
            } else if (userMenuChose == 2) {
                getProductInformation();
            } else if (userMenuChose == 3) {
                getProductListByCategory();
            } else if (userMenuChose == 4) {
                deleteSelectedProduct();
            }

        }
    }

}
