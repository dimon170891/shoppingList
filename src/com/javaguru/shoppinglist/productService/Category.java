package com.javaguru.shoppinglist.productService;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    UNSSIGNED,
    MILK,
    FRUITS,
    VEGETABLES,
    MEAT,
    FISH,
    CHEESE,
    VEGAN;

    public static List getCategoryList() {

        List<Category> categories = new ArrayList<Category>();
        categories.add(UNSSIGNED);
        categories.add(MILK);
        categories.add(FRUITS);
        categories.add(VEGETABLES);
        categories.add(MEAT);
        categories.add(FISH);
        categories.add(CHEESE);
        categories.add(VEGAN);
        return categories;

    }

    public static void printCategoryList() {

        List categories = getCategoryList();

        System.out.println("" + categories.indexOf(UNSSIGNED) + " = " + UNSSIGNED);
        System.out.println("" + categories.indexOf(MILK) + " = " + MILK);
        System.out.println("" + categories.indexOf(FRUITS) + " = " + FRUITS);
        System.out.println("" + categories.indexOf(VEGETABLES) + " = " + VEGETABLES);
        System.out.println("" + categories.indexOf(MEAT) + " = " + MEAT);
        System.out.println("" + categories.indexOf(FISH) + " = " + FISH);
        System.out.println("" + categories.indexOf(CHEESE) + " = " + CHEESE);
        System.out.println("" + categories.indexOf(VEGAN) + " = " + VEGAN);

    }
}
