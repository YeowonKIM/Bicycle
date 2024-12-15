package service;

import domain.Bicycle;
import repository.BicycleRepository;
import view.InputView;
import view.OutputView;

public class BicycleService {
    private final BicycleRepository bicycleRepository;
    private int currentId = 1;

    public BicycleService() {
        this.bicycleRepository = new BicycleRepository();
    }

    public void createBicycle(String input) {
        String[] parts = input.split(", ");
        String model = parts[0];
        int price = Integer.parseInt(parts[1]);
        Bicycle bicycle = new Bicycle(currentId++, model, price);
        bicycleRepository.saveBicycle(bicycle);
    }

}
