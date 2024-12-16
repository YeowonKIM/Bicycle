package repository;

import domain.Bicycle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BicycleRepository {
    private final Map<Integer, Bicycle> bicycleStore = new HashMap<>();

    public void saveBicycle(Bicycle bicycle) {
        bicycleStore.put(bicycle.getId(), bicycle);
    }

    public Map<Integer, Bicycle> getBicycles() {
        return bicycleStore;
    }

    public Optional<Bicycle> getBicycleById(int id) {
        return Optional.ofNullable(bicycleStore.get(id));
    }
}
