package repository;

import domain.Bicycle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Hash map of key-value (id - bike entity) as a data structure
 */
public class BicycleRepository {
    private final Map<Integer, Bicycle> bicycleRack = new HashMap<>();

    public void saveBicycle(Bicycle bicycle) {
        bicycleRack.put(bicycle.getId(), bicycle);
    }

    public Map<Integer, Bicycle> getBicycles() {
        return bicycleRack;
    }

    public Optional<Bicycle> getBicycleById(int id) {
        return Optional.ofNullable(bicycleRack.get(id));
    }

    public void deleteBicycle(int id) { bicycleRack.remove(id); }
}
