package com.javaguru.shoppinglist.userInterface;

import com.javaguru.shoppinglist.DIHelper;

class ShoppingListApplication {

    public static void main(String[] args) {

        MenuNotification.userWelcome();
        UImenu uImenu = DIHelper.createApplication();
        uImenu.mainUserMenu();
        MenuNotification.goodbyeToTheUser();

    }

}
