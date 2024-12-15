package service;

import domain.Bicycle;
import repository.BicycleRepository;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingService {
    private final BicycleRepository bicycleRepository;
    private final OutputView outputView;
    private int currentId = 1;

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

    public SortingService() {
        this.bicycleRepository = new BicycleRepository();
        this.outputView = new OutputView();
    }

    public List<Bicycle> sortBicyclesByPrice() {
        return bicycleRepository.getBicycles().values()
                .stream()
                .sorted(Comparator.comparingDouble(Bicycle::getPrice))
                .collect(Collectors.toList());
    }

    public List<Bicycle> insertionSortBicyclesByPrice() {
        Collection<Bicycle> bicycles = bicycleRepository.getBicycles().values();
        List<Bicycle> bicycleList = new ArrayList<>(bicycles);

        for (int i = 1; i < bicycleList.size(); i++) {
            Bicycle key = bicycleList.get(i);
            int j = i - 1;

            while (j >= 0 && bicycleList.get(j).getPrice() > key.getPrice()) {
                bicycleList.set(j + 1, bicycleList.get(j));
                j--;
            }
            bicycleList.set(j + 1, key);
        }

        return bicycleList;
    }
}
