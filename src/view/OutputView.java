package view;

import domain.Bicycle;
import repository.BicycleRepository;
import service.BicycleService;

import java.util.Map;

import static common.InfoMessage.GREETING;
import static common.InfoMessage.SHOW_BICYCLE;

public class OutputView {

    public OutputView() {
    }

    public void showGreetings() {
        System.out.println(GREETING.getMessage());
    }

    public void showBicycles(Map<Integer, Bicycle> bicycles) {
        System.out.println();
        System.out.println(SHOW_BICYCLE.getMessage());
        for (Bicycle b : bicycles.values()) {
            System.out.println("model: " + b.getModel() + ", " + "price: " + b.getPrice() + ", " + "condition: " + b.getCondition());
        }
    }
}
