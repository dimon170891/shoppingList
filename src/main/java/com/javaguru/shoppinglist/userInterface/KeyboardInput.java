package com.javaguru.shoppinglist.userInterface;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class KeyboardInput {

    private static String deleteLettersAndSymbols(String userChoose) {

        String stringNumber = userChoose.replaceAll("[^-0-9]", ""); // delete all symbols
        if (stringNumber.isEmpty()) {
            return "0"; //exit
        }
        return stringNumber;
    }

    public int getUserNumberInput() {

        Scanner keyReader = new Scanner(System.in);
        String userChose = keyReader.nextLine();

        return Integer.parseInt(deleteLettersAndSymbols(userChose));
    }

    public String getKeyboardInputLine() {

        Scanner keyReader = new Scanner(System.in);
        String string = keyReader.nextLine();

        return string;
    }

    public BigDecimal getKeyboardInputBigDecimal() {

        boolean correctInput = false;
        BigDecimal number = new BigDecimal(0);
        while (!correctInput) {
            try {
                Scanner keyReader = new Scanner(System.in);
                String stringNumber = keyReader.nextLine();
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
