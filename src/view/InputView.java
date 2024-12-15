package view;

import java.io.Console;
import java.util.Scanner;

import static common.InfoMessage.ADD_BICYCLE;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    public String addBicycleInfo() {
        System.out.println();
        System.out.println(ADD_BICYCLE.getMessage());
        String input = scanner.nextLine();
       return input;
    }
}
