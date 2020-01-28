package com.javaguru.shoppinglist.userInterface;

import java.math.BigDecimal;
import java.util.Scanner;

public class KeyboardInput {

    public static int getUserNumberInput() {

        Scanner keyReader = new Scanner(System.in);
        String userChose = keyReader.nextLine();

        return Integer.parseInt(deleteLettersAndSymbols(userChose));
    }

    public static String deleteLettersAndSymbols(String userChoose) {

        String stringNumber = userChoose.replaceAll("[^-0-9]", ""); // delete all symbols
        if (stringNumber.isEmpty()) {
            return "0"; //exit
        }
        return stringNumber;
    }

    public static String getKeyboardInputLine() {

        Scanner keyReader = new Scanner(System.in);
        String string = keyReader.nextLine();

        return string;
    }

    public static BigDecimal getKeyboardInputBigDecimal() {

        boolean correctInput = false;
        BigDecimal number = new BigDecimal(0);
        while (!correctInput) {
            try {
                String stringNumber = getKeyboardInputLine();
                number = new BigDecimal(stringNumber);
                correctInput = true;
            } catch (NumberFormatException f) {
                System.out.println("Bad format! Please enter number in format like 0.00!");
                correctInput = false;
            }
        }
        return number;
    }


}
