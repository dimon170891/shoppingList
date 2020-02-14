package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.businessLogic.ProductService;
import com.javaguru.shoppinglist.dataBase.DataBase;
import com.javaguru.shoppinglist.userInterface.KeyboardInput;
import com.javaguru.shoppinglist.userInterface.UImenu;

public class DIHelper {


    public static UImenu createApplication() {

        DataBase db = new DataBase();
        ProductService productService = new ProductService(db);
        KeyboardInput keyboardInput = new KeyboardInput();
        return new UImenu(productService, keyboardInput);

    }


}
