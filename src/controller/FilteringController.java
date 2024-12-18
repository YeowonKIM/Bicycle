package controller;

import domain.ExecutionResult;
import service.FilteringPriceRangeService;
import view.InputView;
import view.OutputView;

import static common.InfoMessage.FILTERING_PRICE_JAVA;
import static common.InfoMessage.FILTERING_PRICE_LOOP;

/**
 * Subsidiary controller for measuring the execution time of filtering algorithms
 */
public class FilteringController {
    private final InputView inputView;
    private final OutputView outputView;
    private final FilteringPriceRangeService priceRangeService;

    public FilteringController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.priceRangeService = new FilteringPriceRangeService();
    }

    public void runFilteringNavigator() {
        priceRangeService.existingBicycles();
        String input = inputView.filterByPriceInfo();
        filterBicyclesByPriceRange(FILTERING_PRICE_JAVA.getMessage(), priceRangeService.filterByPriceRangeJava(input));
        filterBicyclesByPriceRange(FILTERING_PRICE_LOOP.getMessage(), priceRangeService.filterByPriceRangeLoop(input));
    }

    private void filterBicyclesByPriceRange(String message, ExecutionResult result) {
        outputView.showBicyclesMessage(message);
        outputView.showExecutionResult(result);
    }
}
