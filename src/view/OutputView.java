package view;

import domain.Bicycle;
import repository.BicycleRepository;
import service.BicycleService;

import java.util.List;
import java.util.Map;

import static common.InfoMessage.*;

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

    public void showBicyclesListWithDistance(List<Bicycle> bicycles) {
        int num = 1;
        for (Bicycle b : bicycles) {
            System.out.println(num++ + ") " + "type: " + b.getType() + ", " + "price: " + b.getPrice() + ", " + "condition: " + b.getCondition()+ ", "
                    + "branch: " + b.getBranch().getName() + ", " + "distance: " + b.getDistance() + "km");
        }
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

}
