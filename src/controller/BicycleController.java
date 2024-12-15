package controller;

import domain.Bicycle;
import service.BicycleService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BicycleController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BicycleService bicycleService;

    public BicycleController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bicycleService = new BicycleService();
    }

    public void runBicycleNavigator() {
        // Greeting
        outputView.showGreetings();

        // CRUD
        bicycleService.existingBicycles();
        List<String> inputs = inputView.addBicycleInfo();
        bicycleService.addBicycles(inputs);
        bicycleService.readBicycle();

        // Sorting
        outputView.showBicyclesByPriceInfo();
        List<Bicycle> bicycles = bicycleService.sortBicyclesByPrice();
        outputView.showBicyclesList(bicycles);
    }
}
