package service;

import domain.Bicycle;
import repository.BicycleRepository;
import view.InputView;
import view.OutputView;

import java.util.Collection;
import java.util.Map;

public class BicycleService {
    private final BicycleRepository bicycleRepository;
    private final OutputView outputView;
    private int currentId = 1;

    public BicycleService() {
        this.bicycleRepository = new BicycleRepository();
        this.outputView = new OutputView();
    }

    public void createBicycle(String input) {
        String[] parts = input.split(", ");
        String model = parts[0];
        int price = Integer.parseInt(parts[1]);
        Bicycle bicycle = new Bicycle(currentId++, model, price);
        bicycleRepository.saveBicycle(bicycle);
    }

    public void readBicycle() {
        Map<Integer, Bicycle> bicycles = bicycleRepository.getBicycles();
        outputView.showBicycles(bicycles);
    }

}
