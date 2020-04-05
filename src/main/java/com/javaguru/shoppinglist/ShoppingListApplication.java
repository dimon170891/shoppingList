package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.userInterface.MenuNotification;
import com.javaguru.shoppinglist.userInterface.UImenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class ShoppingListApplication {

    public static void main(String[] args) {

        MenuNotification.userWelcome();
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(AppConfig.class);

        UImenu uImenu = context.getBean(UImenu.class);
        uImenu.mainUserMenu();
        MenuNotification.goodbyeToTheUser();

        // System.out.println("Test");
    }

}
