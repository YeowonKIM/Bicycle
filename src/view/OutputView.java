package view;

import service.BicycleService;

import static common.InfoMessage.GREETING;

public class OutputView {
    private final BicycleService bicycleService;

    public OutputView() {
        this.bicycleService = new BicycleService();
    }

    public void showGreetings() {
        System.out.println(GREETING.getMessage());
    }
}
