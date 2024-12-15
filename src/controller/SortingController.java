package controller;

import domain.Bicycle;
import service.BicycleService;
import service.SortingService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class SortingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BicycleService bicycleService;
    private final SortingService sortingService;

    public SortingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bicycleService = new BicycleService();
        this.sortingService = new SortingService();
    }

    public void runSortingNavigator() {
        sortingService.existingBicycles();

        // Sorting 1 - Java sorted() method
        outputView.showBuiltinSortByPriceInfo();
        List<Bicycle> bicycles = sortingService.sortBicyclesByPrice();
        outputView.showBicyclesList(bicycles);

        // Sorting 2 - Insertion Sort
        outputView.showInsertionSortByPriceInfo();
        List<Bicycle> insertionSortedBicycles = sortingService.insertionSortBicyclesByPrice();
        outputView.showBicyclesList(insertionSortedBicycles);
    }
}
