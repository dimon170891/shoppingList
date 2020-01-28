package com.javaguru.shoppinglist.userInterface;

import com.javaguru.shoppinglist.productService.Category;
import com.javaguru.shoppinglist.productService.Product;
import com.javaguru.shoppinglist.productService.ProductService;

import java.math.BigDecimal;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {

        MenuNotification.userWelcome();
        mainUserMenu();
        MenuNotification.goodbyeToTheUser();

    }

    public static void mainUserMenu() {

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

    private static void createNewProduct() {

        System.out.println("======   Please enter product name! Name cannot be less than 3 characters and more than 32! ");
        String name = KeyboardInput.getKeyboardInputLine();

        System.out.println("======   Please enter product pice in format like 0.00 ! Product price must be greater than 0! ");
        BigDecimal priceBD = KeyboardInput.getKeyboardInputBigDecimal();

        System.out.println("======   Please enter product discount  in format like 0.00. Discount cannot be more than 100 percent!");
        BigDecimal discount = KeyboardInput.getKeyboardInputBigDecimal();

        ProductService productService = new ProductService();
        Product newProduct = productService.createProduct(name, priceBD, discount);
        productService.writeProductInDataBase(newProduct);

        if (!(newProduct == Product.emptyProduct)) {
            setCategory(productService, newProduct);
            setDescription(newProduct);
            System.out.println("======   You created product : ");
            System.out.println(newProduct.toString());
        }
    }


    public static void setDescription(Product product) {

        MenuNotification.descriptionTextQuestion();

        KeyboardInput ki = new KeyboardInput();
        int userChose = ki.getUserNumberInput();
        if (userChose > 0) {
            setProductDescription(product);
        }

    }

    public static void setCategory(ProductService productService, Product product) {

        MenuNotification.settingCategoryTextQuestion();

        KeyboardInput ki = new KeyboardInput();
        int userChose = ki.getUserNumberInput();
        if (userChose > 0) {
            Category category = getCategoryByMenu();
            productService.setproductCategory(product, category);
        }

    }

    public static Category getCategoryByMenu() {
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

    private static void setProductDescription(Product product) {

        MenuNotification.descriptionTextSetting();

        String description = KeyboardInput.getKeyboardInputLine();
        ProductService ps = new ProductService();
        ps.setProductDescription(product, description);

    }


    private static void getProductInformation() {

        Product receivedProduct = getProductAcrossMenue();

        if (!(receivedProduct == Product.emptyProduct)) {
            System.out.println(receivedProduct.toString());
        } else {
            System.out.println("Product dont search!");
        }

    }

    private static Product getProductAcrossMenue() {

        Product receivedProduct = Product.emptyProduct;
        MenuNotification.gettingProductTextQuestion();

        ProductService productService = new ProductService();

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


    private static void deleteSelectedProduct() {
        MenuNotification.productSelectingToDeleteText();
        Product productToDelete = getProductAcrossMenue();

        if (!(productToDelete == Product.emptyProduct)) {
            ProductService productService = new ProductService();
            productService.deleteProductFromDataBase(productToDelete);
            System.out.println("Product " + productToDelete.toString() + "deleted");
        } else {
            System.out.println("Dont searched product");
        }

    }

    private static void getProductListByCategory() {
        Category category = getCategoryByMenu();
        ProductService productService = new ProductService();
        List<Product> productList = productService.getProducrListFromDataBaseByCategory(category);
        System.out.println(productList.toString());
    }


}
