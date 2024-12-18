import controller.BicycleController;

/**
 * Execution of overall features
 */
public class BicycleApplication {
    public static void main(String[] args) {
        BicycleController bicycleController = new BicycleController();
        bicycleController.runBicycleNavigator();
    }
}