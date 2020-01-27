package com.javaguru.shoppinglist.userInterface;

import com.javaguru.shoppinglist.productService.Category;
import com.javaguru.shoppinglist.productService.Product;
import com.javaguru.shoppinglist.productService.ProductService;

import java.math.BigDecimal;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {


        MenuNotification.userWelcome();
        MenuNotification.userMenu();
        mainUserMenu();
        MenuNotification.goodbyeToTheUser();


    }

    public static void mainUserMenu() {

        int userMenuChose = KeyboardInput.getUserNumberInput();
        if ((userMenuChose >= 1 && userMenuChose <= 4)) {

            while (userMenuChose >= 1 && userMenuChose <= 4) {

                if (userMenuChose == 1) {          //add
                    createNewProduct();
                } else if (userMenuChose == 2) {  // get
                    getProductInformation();
                } else if (userMenuChose == 3) {  // get list
                    getProductListByCategory();
                } else if (userMenuChose == 4) {  // delete
                    deleteSelectedProduct();
                }
                MenuNotification.userMenu();
                userMenuChose = KeyboardInput.getUserNumberInput();

            }
        }
    }

    private static void createNewProduct() {

        System.out.println("======   Please enter product name: ");
        String name = KeyboardInput.getKeyboardInputLine();

        System.out.println("======   Please enter product pice in format like 0.00  : ");
        BigDecimal priceBD = KeyboardInput.getKeyboardInputBigDecimal();

        System.out.println("======   Please enter product discount from 1 to 99 % in format like 0.00 . If discount == 0 please enter 0: ");
        BigDecimal discount = KeyboardInput.getKeyboardInputBigDecimal();

        ProductService productService = new ProductService();
        Product newProduct = productService.createProduct(name, priceBD, discount);
        productService.writeProductInDataBase(newProduct);

        setCategory(productService, newProduct);
        setDescription(newProduct);


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
