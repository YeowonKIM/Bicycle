package service;

import domain.Bicycle;
import domain.Branch;
import repository.BicycleRepository;
import repository.BranchRepository;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDistanceService {
    private final BicycleRepository bicycleRepository;
    private final BranchRepository branchRepository;
    private final OutputView outputView;
    private int currentBicycleId = 1;
    private int currentBranchId = 1;

    public void existingBicycles() {
        Branch branch1 = new Branch(currentBranchId++, "Champs-Élysées", 48.8698, 2.3078);  // Champs-Élysées
        Branch branch2 = new Branch(currentBranchId++, "Tour Eiffel", 48.8584, 2.2945);  // Tour Eifflel
        Branch branch3 = new Branch(currentBranchId++, "Musée d'Orsay", 48.8599, 2.3266);  // Musée d'Orsay
        Branch branch4 = new Branch(currentBranchId++, "Grand Palais", 48.8662, 2.3125);  // Grand Palais

        Bicycle bicycle1 = new Bicycle(currentBicycleId++, "memchanical", 30, "good", branch1, 0);
        Bicycle bicycle2 = new Bicycle(currentBicycleId++, "memchanical", 20, "bad", branch2, 0);
        Bicycle bicycle3 = new Bicycle(currentBicycleId++, "electric", 60, "good", branch3, 0);
        Bicycle bicycle4 = new Bicycle(currentBicycleId++, "electric", 50, "good", branch4, 0);

        branchRepository.saveBranch(branch1);
        branchRepository.saveBranch(branch2);
        branchRepository.saveBranch(branch3);
        branchRepository.saveBranch(branch4);

        bicycleRepository.saveBicycle(bicycle1);
        bicycleRepository.saveBicycle(bicycle2);
        bicycleRepository.saveBicycle(bicycle3);
        bicycleRepository.saveBicycle(bicycle4);
    }

    public SortingDistanceService() {
        this.bicycleRepository = new BicycleRepository();
        this.branchRepository = new BranchRepository();
        this.outputView = new OutputView();
    }

    public List<Bicycle> sortBicyclesByDistance(String input) {
        String[] parts = input.split(", ");
        double latitude = Double.parseDouble(parts[0]);
        double longitude = Double.parseDouble(parts[1]);

        List<Bicycle> bicycles = getBicycleList();
        for (Bicycle b : bicycles) {
            double distance = calculateDistance(latitude, longitude, b.getBranch().getLatitude(), b.getBranch().getLongitude());
            b.setDistance(distance);
        }

        return bicycleRepository.getBicycles().values()
                .stream()
                .sorted(Comparator.comparingDouble(Bicycle::getDistance))
                .collect(Collectors.toList());
    }

    // Sorting 2 - Insertion Sort
    public List<Bicycle> insertionSortBicyclesByDistance() {
        List<Bicycle> bicycleList = getBicycleList();

        for (int i = 1; i < bicycleList.size(); i++) {
            Bicycle key = bicycleList.get(i);
            int j = i - 1;

            while (j >= 0 && bicycleList.get(j).getDistance() > key.getDistance()) {
                bicycleList.set(j + 1, bicycleList.get(j));
                j--;
            }
            bicycleList.set(j + 1, key);
        }

        return bicycleList;
    }

    private List<Bicycle> getBicycleList() {
        Collection<Bicycle> bicycles = bicycleRepository.getBicycles().values();
        List<Bicycle> bicycleList = new ArrayList<>(bicycles);
        return bicycleList;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int EARTH_RADIUS_KM = 6371; // Earth's radius in kilometers

        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Calculate the differences between latitudes and longitudes
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Apply the Haversine formula
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        return EARTH_RADIUS_KM * c;
    }

}
