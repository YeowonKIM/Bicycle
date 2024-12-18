import controller.FilteringController;
import controller.SortingController;

/**
 * Running processes to assess the execution time of each filtering algorithm
 */
public class FilteringApplication {
    public static void main(String[] args) {
        FilteringController filteringController = new FilteringController();
        filteringController.runFilteringNavigator();
    }
}
