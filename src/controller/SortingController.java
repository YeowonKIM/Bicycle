package controller;

import domain.Bicycle;
import service.BicycleService;
import service.SortingDistanceService;
import service.SortingPriceService;
import view.InputView;
import view.OutputView;

import java.util.List;

import static common.InfoMessage.*;

public class SortingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BicycleService bicycleService;
    private final SortingPriceService sortingPriceService;
    private final SortingDistanceService sortingDistanceService;

    public SortingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bicycleService = new BicycleService();
        this.sortingPriceService = new SortingPriceService();
        this.sortingDistanceService = new SortingDistanceService();
    }

    public void runSortingNavigator() {
        sortingPriceService.existingBicycles();
        sortingDistanceService.existingBicycles();

        // Sorting 1 - Java sorted() method
        sortBicyclesByPrice(JAVA_SORT_PRICE.getMessage(), sortingPriceService.sortBicyclesByPrice());
        // Sorting 2 - Insertion Sort
        sortBicyclesByPrice(INSERTION_SORT_PRICE.getMessage(), sortingPriceService.insertionSortBicyclesByPrice());
        // Sorting 3 - Merge Sort
        sortBicyclesByPrice(Merge_SORT_PRICE.getMessage(), sortingPriceService.mergeSortBicyclesByPrice());
        // Sorting 4 - Tim Sort
        sortBicyclesByPrice(TIM_SORT_PRICE.getMessage(), sortingPriceService.timSortBicyclesByPrice());

        // MyLocation
        inputView.getDivisionLine();
        String input = inputView.addMyLocation();

        // Sorting 1 - Java sorted() method
        sortByDistance(input, JAVA_SORT_DISTANCE.getMessage(), sortingDistanceService.sortBicyclesByDistance(input));
        // Sorting 2 - Insertion Sort
        sortByDistance(input, INSERTION_SORT_DISTANCE.getMessage(), sortingDistanceService.insertionSortBicyclesByDistance());
    }

    private void sortByDistance(String input, String message, List<Bicycle> bicyclesSortedDistance) {
        outputView.showBicyclesMessage(message);
        outputView.showBicyclesListWithDistance(bicyclesSortedDistance);
    }

    private void sortBicyclesByPrice(String message, List<Bicycle> bicycles) {
        outputView.showBicyclesMessage(message);
        outputView.showBicyclesList(bicycles);
    }
}
