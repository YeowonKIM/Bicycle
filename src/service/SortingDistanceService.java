package service;

import domain.Bicycle;
import domain.Branch;
import domain.ExecutionResult;
import repository.BicycleRepository;
import repository.BranchRepository;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Subsidiary section for measuring the execution time of sorting algorithms (Java built-in method, Insertion sort, Merge Sort)
 */
public class SortingDistanceService {
    private final BicycleRepository bicycleRepository;
    private final BranchRepository branchRepository;
    private final OutputView outputView;
    private int currentBicycleId = 1;
    private int currentBranchId = 1;

    public SortingDistanceService() {
        this.bicycleRepository = new BicycleRepository();
        this.branchRepository = new BranchRepository();
        this.outputView = new OutputView();
    }

    public ExecutionResult sortBicyclesByDistance(String input) {
        long startTime = System.nanoTime();

        String[] parts = input.split(", ");
        double latitude = Double.parseDouble(parts[0]);
        double longitude = Double.parseDouble(parts[1]);

        List<Bicycle> bicycles = getBicycleList();
        for (Bicycle b : bicycles) {
            double distance = calculateDistance(latitude, longitude, b.getBranch().getLatitude(), b.getBranch().getLongitude());
            distance = Math.round(distance * 100.0) / 100.0;
            b.setDistance(distance);
        }

        List<Bicycle> bicycleList = bicycleRepository.getBicycles().values()
                .stream()
                .sorted(Comparator.comparingDouble(Bicycle::getDistance))
                .collect(Collectors.toList());

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return new ExecutionResult(bicycleList, duration);
    }

    // Sorting 2 - Insertion Sort
    public ExecutionResult insertionSortBicyclesByDistance() {
        Long startTime = System.nanoTime();

        List<Bicycle> bicycleList = getBicycleList();
        int n = bicycleList.size();

        for (int i = 1; i < n; i++) {
            Bicycle key = bicycleList.get(i);
            int j = i - 1;

            if (bicycleList.get(j).getPrice() <= key.getPrice()) {
                continue;
            }

            while (j >= 0 && bicycleList.get(j).getDistance() > key.getDistance()) {
                bicycleList.set(j + 1, bicycleList.get(j));
                j--;
            }
            bicycleList.set(j + 1, key);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return new ExecutionResult(bicycleList, duration);
    }

    // Sorting 3 - Merge Sort
    public ExecutionResult mergeSortBicyclesByDistance() {
        long startTime = System.nanoTime();

        List<Bicycle> bicycleList = getBicycleList();
        mergeSort(bicycleList, 0, bicycleList.size() - 1);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return new ExecutionResult(bicycleList, duration);
    }

    private void mergeSort(List<Bicycle> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the left and right halves
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            // Merge the sorted halves
            merge(list, left, mid, right);
        }
    }

    // Merge two sorted halves of the list
    private void merge(List<Bicycle> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary lists for left and right sublists
        List<Bicycle> leftList = new ArrayList<>(n1);
        List<Bicycle> rightList = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftList.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(list.get(mid + 1 + j));
        }

        // Merge the two sublists back into the original list
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getDistance() <= rightList.get(j).getDistance()) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left sublist
        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
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

    public void existingBicycles() {
        Branch branch1 = new Branch(currentBranchId++, "Champs-Élysées", 48.8698, 2.3078);  // Champs-Élysées
        Branch branch2 = new Branch(currentBranchId++, "Tour Eiffel", 48.8584, 2.2945);  // Tour Eifflel
        Branch branch3 = new Branch(currentBranchId++, "Musée d'Orsay", 48.8599, 2.3266);  // Musée d'Orsay
        Branch branch4 = new Branch(currentBranchId++, "Grand Palais", 48.8662, 2.3125);  // Grand Palais
        Branch branch5 = new Branch(currentBranchId++, "Panthéon", 48.8462, 2.344); // Panthéon

        Bicycle bicycle1 = new Bicycle(currentBicycleId++, "mechanical", 70, "good", branch1, 0);
        Bicycle bicycle2 = new Bicycle(currentBicycleId++, "mechanical", 50, "bad", branch2, 0);
        Bicycle bicycle3 = new Bicycle(currentBicycleId++, "mechanical", 40, "bad", branch3, 0);
        Bicycle bicycle4 = new Bicycle(currentBicycleId++, "electric", 90, "good", branch4, 0);
        Bicycle bicycle5 = new Bicycle(currentBicycleId++, "electric", 110, "good", branch5, 0);

        branchRepository.saveBranch(branch1);
        branchRepository.saveBranch(branch2);
        branchRepository.saveBranch(branch3);
        branchRepository.saveBranch(branch4);

        bicycleRepository.saveBicycle(bicycle1);
        bicycleRepository.saveBicycle(bicycle2);
        bicycleRepository.saveBicycle(bicycle3);
        bicycleRepository.saveBicycle(bicycle4);
        bicycleRepository.saveBicycle(bicycle5);
    }

}
