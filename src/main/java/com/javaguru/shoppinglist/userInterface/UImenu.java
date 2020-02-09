package com.javaguru.shoppinglist.userInterface;

import com.javaguru.shoppinglist.businessLogic.Category;
import com.javaguru.shoppinglist.businessLogic.Product;
import com.javaguru.shoppinglist.businessLogic.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class UImenu {

    private ProductService productService;

    public UImenu(ProductService productService) {
        this.productService = productService;
    }

    private void createNewProduct() {

        System.out.println("======   Please enter product name! Name cannot be less than 3 characters and more than 32! ");
        String name = KeyboardInput.getKeyboardInputLine();

        System.out.println("======   Please enter product pice in format like 0.00 ! Product price must be greater than 0! ");
        BigDecimal priceBD = KeyboardInput.getKeyboardInputBigDecimal();

        System.out.println("======   Please enter product discount  in format like 0.00. Discount cannot be more than 100 percent!");
        BigDecimal discount = KeyboardInput.getKeyboardInputBigDecimal();

        Product newProduct = productService.createProduct(name, priceBD, discount);
        productService.writeProductInDataBase(newProduct);

        if (!(newProduct == Product.emptyProduct)) {
            setCategory(productService, newProduct);
            setDescription(newProduct);
            System.out.println("======   You created product : ");
            System.out.println(newProduct.toString());
        }
    }

    private void setDescription(Product product) {

        MenuNotification.descriptionTextQuestion();

        KeyboardInput ki = new KeyboardInput();
        int userChose = ki.getUserNumberInput();
        if (userChose > 0) {
            setProductDescription(product);
        }

    }

    private void setCategory(ProductService productService, Product product) {

        MenuNotification.settingCategoryTextQuestion();

        KeyboardInput ki = new KeyboardInput();
        int userChose = ki.getUserNumberInput();
        if (userChose > 0) {
            Category category = getCategoryByMenu();
            productService.setproductCategory(product, category);
        }

    }

    private static Category getCategoryByMenu() {
        Category category = Category.UNSSIGNED;
        MenuNotification.checkingCategoryText();
        Category.printCategoryList();

        KeyboardInput ki = new KeyboardInput();
        int userChose = ki.getUserNumberInput();
        if (userChose < Category.getCategoryList().size()) {
            category = (Category) Category.getCategoryList().get(userChose);
        }
        return category;
    }

    private void setProductDescription(Product product) {

        MenuNotification.descriptionTextSetting();

        String description = KeyboardInput.getKeyboardInputLine();
        productService.setProductDescription(product, description);

    }

    private void getProductInformation() {

        Product receivedProduct = getProductAcrossMenue();

        if (!(receivedProduct == Product.emptyProduct)) {
            System.out.println(receivedProduct.toString());
        } else {
            System.out.println("Product dont search!");
        }

    }

    private Product getProductAcrossMenue() {

        Product receivedProduct = Product.emptyProduct;
        MenuNotification.gettingProductTextQuestion();

        KeyboardInput ki = new KeyboardInput();

        int userChose = ki.getUserNumberInput();
        if (userChose == 1) {
            System.out.println("enter product ID to search ");
            Long iD = new Long(ki.getUserNumberInput());

            receivedProduct = productService.getProducrFromDataBase(iD);
        } else {
            System.out.println("enter product name to search ");
            String productName = KeyboardInput.getKeyboardInputLine();
            receivedProduct = productService.getProducrFromDataBase(productName);
        }
        return receivedProduct;
    }

    private void deleteSelectedProduct() {
        MenuNotification.productSelectingToDeleteText();
        Product productToDelete = getProductAcrossMenue();

        if (!(productToDelete == Product.emptyProduct)) {
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

            userMenuChose = KeyboardInput.getUserNumberInput();

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
