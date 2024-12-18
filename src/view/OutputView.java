package view;

import domain.Bicycle;
import domain.ExecutionResult;

import java.util.List;
import java.util.Map;

import static common.InfoMessage.*;

/**
 * Managing output format
 */
public class OutputView {

    public OutputView() {
    }

    public void showGreetings() {
        System.out.println();
        System.out.println(GREETING.getMessage());
    }

    public void showBicycles(Map<Integer, Bicycle> bicycles) {
        System.out.println();
        System.out.println(SHOW_BICYCLE.getMessage());
        int num = 1;
        for (Bicycle b : bicycles.values()) {
            System.out.println(num++ + ") " + "type: " + b.getType() + ", " + "price: " + b.getPrice() + ", " + "condition: " + b.getCondition() + ", " + "branch: " + b.getBranch().getName());
        }
    }

    public void showBicyclesList(List<Bicycle> bicycles) {
        int num = 1;
        for (Bicycle b : bicycles) {
            System.out.println(num++ + ") " + "type: " + b.getType() + ", " + "price: " + b.getPrice() + ", " + "condition: " + b.getCondition()+ ", " + "branch: " + b.getBranch().getName());
        }
    }

    public void showExecutionResult(ExecutionResult result) {
        int num = 1;
        for (Bicycle b : result.getBicycles()) {
            System.out.println(num++ + ") " + "type: " + b.getType() + ", " + "price: " + b.getPrice() + ", " + "condition: " + b.getCondition()+ ", " + "branch: " + b.getBranch().getName());
        }
        System.out.println("=> Execution time: " + result.getDurationSeconds() + " nanoseconds");
    }

    public void showBicyclesListWithDistance(List<Bicycle> bicycles) {
        int num = 1;
        for (Bicycle b : bicycles) {
            System.out.println(num++ + ") " + "type: " + b.getType() + ", " + "price: " + b.getPrice() + ", " + "condition: " + b.getCondition()+ ", "
                    + "branch: " + b.getBranch().getName() + ", " + "distance: " + b.getDistance() + "km");
        }
    }

    public void showResultWithDistance(ExecutionResult result) {
        int num = 1;
        for (Bicycle b : result.getBicycles()) {
            System.out.println(num++ + ") " + "type: " + b.getType() + ", " + "price: " + b.getPrice() + ", " + "condition: " + b.getCondition()+ ", "
                    + "branch: " + b.getBranch().getName() + ", " + "distance: " + b.getDistance() + "km");
        }
        System.out.println("=> Execution time: " + result.getDurationSeconds() + " nanoseconds");
    }

    public void showBicyclesByPriceInfo() {
        System.out.println();
        System.out.println(SORTING_PRICE.getMessage());
    }

    public void showBicyclesMessage(String message) {
        System.out.println();
        System.out.println(message);
    }

    public void showBicyclesByDistanceInfo() {
        System.out.println();
        System.out.println(SORTING_DISTANCE.getMessage());
    }

    public void getExecutionTime(long duration) {
        System.out.println("=> Execution time: " + duration + " nanoseconds");
    }

    public void getDivisionLine() {
        System.out.println();
        System.out.println(DIVIDE_BY_LINE.getMessage());
    }

}
