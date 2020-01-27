package com.javaguru.shoppinglist.userInterface;

public class MenuNotification {

    public static void goodbyeToTheUser() {

        System.out.println("======================================================================================================");
        System.out.println("=============================== GOODBYE ITS WOS GOOD WORK  ============================================");
        System.out.println("======================================================================================================");

    }


    public static void userWelcome() {

        System.out.println("======================================================================================================");
        System.out.println("=============================== WELCOME IN SUPER PRODUCT DATA BASE  ==================================");
        System.out.println("===================================== PLEASE CHECK YOR CHOSE  ========================================");

    }


    public static void userMenu() {

        System.out.println("============================================ MAIN MENU ================================================");
        System.out.println("Please enter 1 to create product");
        System.out.println("Please enter 2 to get product");
        System.out.println("Please enter 3 to get product list");
        System.out.println("Please enter 4 to delete product");
        System.out.println("Please enter 5  or some other to exit programs");


    }

    public static void descriptionTextQuestion() {
        System.out.println("======================================== DESCRIPTION ================================================");
        System.out.println("if you want set product description please enter 1 or more / for decline setting description please 0");
    }

    public static void descriptionTextSetting() {
        System.out.println("===================================== PLEASE ENTER PRODUCT DESCRIPTON  ========================================");
    }


    public static void gettingProductTextQuestion() {
        System.out.println("=========================================== GETTING PRODUCT ================================================");
        System.out.println("if you want get product get by ID please enter 1  / get by name enter 2 or more ");

    }

    public static void settingCategoryTextQuestion() {
        System.out.println("=========================================== SETTING CATEGORY ================================================");
        System.out.println("if you want set product category please enter 1 or more / for decline setting category please 0");
    }

    public static void checkingCategoryText() {
        System.out.println("===================================== PLEASE CHECK YOR CATEGORY  ========================================");
    }

    public static void productSelectingToDeleteText() {
        System.out.println("===================================== PLEASE SELECTING PRODUCT TO DELETE  ========================================");
    }

}
