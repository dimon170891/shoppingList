package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.businessLogic.ProductService;
import com.javaguru.shoppinglist.dataBase.DataBase;
import com.javaguru.shoppinglist.userInterface.UImenu;
import com.javaguru.shoppinglist.validation.ProductValidationService;

public class DIHelper {


    public static UImenu createApplication() {

        DataBase db = new DataBase();

        ProductValidationService productValidationService = new ProductValidationService(db);

        ProductService productService = new ProductService(db, productValidationService);

        return new UImenu(productService);

    }


}
