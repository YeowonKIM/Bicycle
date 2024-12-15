package controller;

import domain.Bicycle;
import service.BicycleService;
import service.SortingService;
import view.InputView;
import view.OutputView;

import java.util.List;

import static common.InfoMessage.*;

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
        sortBicycles(JAVA_SORT.getMessage(), sortingService.sortBicyclesByPrice());

        // Sorting 2 - Insertion Sort
        sortBicycles(INSERTION_SORT.getMessage(), sortingService.insertionSortBicyclesByPrice());

        // Sorting 3 - Merge Sort
        sortBicycles(Merge_SORT.getMessage(), sortingService.mergeSortBicyclesByPrice());

        // Sorting 4 - Tim Sort
        sortBicycles(TIM_SORT.getMessage(), sortingService.timSortBicyclesByPrice());
    }

    private void sortBicycles(String message, List<Bicycle> bicycles) {
        outputView.showBicyclesByPriceInfoMessage(message);
        outputView.showBicyclesList(bicycles);
    }
}
