package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static common.InfoMessage.*;

/**
 * Managing input guide and receiving section
 */
public class InputView {
    Scanner scanner = new Scanner(System.in);

    public List<String> addBicycleInfo() {
        System.out.println();
        System.out.println(ADD_BICYCLE.getMessage());
        System.out.println(STOP_ADDING.getMessage());
        List<String> inputs = new ArrayList<>();

        while (true) {
            System.out.println(ADD_BICYCLE_INFO.getMessage());
            String input = scanner.nextLine();

            // 종료 조건
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            inputs.add(input);
        }
        return inputs;
    }

    public String addMyLocation() {
        System.out.println(ADD_MY_LOCATION_INFO.getMessage());
        String input = scanner.nextLine();
        return input;
    }

    public String changeBicycleInfo() {
        System.out.println();
        System.out.println(CHANGE_BICYCLE_INFO.getMessage());
        System.out.println(ENTER_NUMBER.getMessage());
        String input = scanner.nextLine();
        return input;
    }

    public String changeBicycleDetail() {
        System.out.println(ENTER_BICYCLE_CHANGE.getMessage());
        String input = scanner.nextLine();
        return input;
    }

    public String deleteBicycleInfo() {
        System.out.println();
        System.out.println(DELETE_A_BICYCYLE.getMessage());
        System.out.println(ENTER_BICYCLE_DELETE.getMessage());
        String input = scanner.nextLine();
        return input;
    }

    public String filterByPriceInfo() {
        System.out.println();
        System.out.println(FILTERING_PRICE.getMessage());
        System.out.println(ENTER_PRICE_RANGE.getMessage());
        String input = scanner.nextLine();
        return input;
    }

}
