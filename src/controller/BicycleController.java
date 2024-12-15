package controller;

import service.BicycleService;
import view.InputView;
import view.OutputView;

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
        // TODO : Add skip
        String input = inputView.addBicycleInfo();
        bicycleService.createBicycle(input);
        bicycleService.readBicycle();
    }
}
