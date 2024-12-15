package repository;

import domain.Bicycle;

import java.util.HashMap;
import java.util.Map;

public class BicycleRepository {
    private final Map<Integer, Bicycle> bicycleStore = new HashMap<>();

    public void saveBicycle(Bicycle bicycle) {
        bicycleStore.put(bicycle.getId(), bicycle);
    }

}
