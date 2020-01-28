package com.javaguru.shoppinglist.userInterface;

class ShoppingListApplication {

    public static void main(String[] args) {

        MenuNotification.userWelcome();
        UImenu uImenu = new UImenu();
        uImenu.mainUserMenu();
        MenuNotification.goodbyeToTheUser();

    }

}
