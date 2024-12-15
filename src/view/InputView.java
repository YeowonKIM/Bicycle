package view;

import java.io.Console;
import java.util.Scanner;

import static common.InfoMessage.ADD_BICYCLE;
import static common.InfoMessage.ADD_BICYCLE_INFO;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    public String addBicycleInfo() {
        System.out.println();
        System.out.println(ADD_BICYCLE.getMessage());
        System.out.println(ADD_BICYCLE_INFO.getMessage());
        String input = scanner.nextLine();
       return input;
    }
}
