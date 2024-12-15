package service;

import domain.Bicycle;
import repository.BicycleRepository;
import view.InputView;
import view.OutputView;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BicycleService {
    private final BicycleRepository bicycleRepository;
    private final OutputView outputView;
    private int currentId = 1;

    public BicycleService() {
        this.bicycleRepository = new BicycleRepository();
        this.outputView = new OutputView();
    }

    public void addBicycles(List<String> inputs) {
        for (String input : inputs) {
            createBicycle(input);
        }
    }

    public void existingBicycles() {
        Bicycle bicycle1 = new Bicycle(currentId++, "memchanical", 30, "good");
        Bicycle bicycle2 = new Bicycle(currentId++, "memchanical", 20, "bad");
        Bicycle bicycle3 = new Bicycle(currentId++, "electric", 60, "good");
        Bicycle bicycle4 = new Bicycle(currentId++, "electric", 50, "good");
        bicycleRepository.saveBicycle(bicycle1);
        bicycleRepository.saveBicycle(bicycle2);
        bicycleRepository.saveBicycle(bicycle3);
        bicycleRepository.saveBicycle(bicycle4);
    }

    public void createBicycle(String input) {
        String[] parts = input.split(", ");
        String type = parts[0];
        int price = Integer.parseInt(parts[1]);
        String condition = parts[2];
        Bicycle bicycle = new Bicycle(currentId++, type, price, condition);
        bicycleRepository.saveBicycle(bicycle);
    }

    public void readBicycle() {
        Map<Integer, Bicycle> bicycles = bicycleRepository.getBicycles();
        outputView.showBicycleMap(bicycles);
    }

    public List<Bicycle> sortBicyclesByPrice() {
        return bicycleRepository.getBicycles().values()
                .stream()
                .sorted(Comparator.comparingDouble(Bicycle::getPrice))
                .collect(Collectors.toList());
    }

}
