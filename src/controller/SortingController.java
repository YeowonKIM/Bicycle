package controller;

import domain.ExecutionResult;
import service.BicycleService;
import service.SortingDistanceService;
import service.SortingPriceService;
import view.InputView;
import view.OutputView;
import static common.InfoMessage.*;

/**
 * Subsidiary controller for measuring the execution time of sorting algorithms (Java built-in method, Insertion sort, Merge Sort)
 */
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

        // MyLocation
        outputView.getDivisionLine();
        String input = inputView.addMyLocation();

        // Sorting 1 - Java sorted() method
        sortByDistance(JAVA_SORT_DISTANCE.getMessage(), sortingDistanceService.sortBicyclesByDistance(input));
        // Sorting 2 - Insertion Sort
        sortByDistance(INSERTION_SORT_DISTANCE.getMessage(), sortingDistanceService.insertionSortBicyclesByDistance());
        // Sorting 3 - Merge Sort
        sortByDistance(Merge_SORT_DISTANCE.getMessage(), sortingDistanceService.mergeSortBicyclesByDistance());

    }

    private void sortBicyclesByPrice(String message, ExecutionResult result) {
        outputView.showBicyclesMessage(message);
        outputView.showExecutionResult(result);
    }

    private void sortByDistance(String message, ExecutionResult result) {
        outputView.showBicyclesMessage(message);
        outputView.showResultWithDistance(result);
    }

}
