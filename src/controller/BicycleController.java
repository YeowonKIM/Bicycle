package controller;

import domain.Bicycle;
import service.BicycleService;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * Main controller that handles overall features
 */
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
        String inputUpdate = inputView.changeBicycleInfo();
        String inputDetails = inputView.changeBicycleDetail();
        bicycleService.updateBike(inputUpdate, inputDetails);
        bicycleService.readBicycle();
        String inputDelete = inputView.deleteBicycleInfo();
        bicycleService.deleteBicycle(inputDelete);
        bicycleService.readBicycle();

        // Sorting bicycles by price
        outputView.getDivisionLine();
        outputView.showBicyclesByPriceInfo();
        List<Bicycle> bicycleList = bicycleService.getBicycleList();
        List<Bicycle> bicycles = bicycleService.sortBicyclesByPrice(bicycleList);
        outputView.showBicyclesList(bicycles);

        // Sorting bicycles by distance
        outputView.showBicyclesByDistanceInfo();
        String input = inputView.addMyLocation();
        List<Bicycle> bicyclesSortedDistance = bicycleService.sortBicyclesByDistance(input);
        outputView.showBicyclesListWithDistance(bicyclesSortedDistance);

        // Filtering by price range
        outputView.getDivisionLine();
        String priceRangeInput = inputView.filterByPriceInfo();
        List<Bicycle> bicyclesFiltered = bicycleService.filterBicyclesByPriceRange(priceRangeInput);
        outputView.showBicyclesList(bicyclesFiltered);
    }
}
