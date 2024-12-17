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

public class SortingPriceService {
    private final BicycleRepository bicycleRepository;
    private final BranchRepository branchRepository;
    private final OutputView outputView;
    private int currentBicycleId = 1;
    private int currentBranchId = 1;

    public SortingPriceService() {
        this.bicycleRepository = new BicycleRepository();
        this.branchRepository = new BranchRepository();
        this.outputView = new OutputView();
    }

    // Sorting 1 - Java sorted() method (with stream)
    public ExecutionResult sortBicyclesByPrice() {
        List<Bicycle> bicycleList = getBicycleList();

        long startTime = System.nanoTime();
        List<Bicycle> bicycles = bicycleList.stream()
                .sorted(Comparator.comparingDouble(Bicycle::getPrice))
                .collect(Collectors.toList());

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return new ExecutionResult(bicycles, duration);
    }

    // Sorting 2 - Insertion Sort
    public ExecutionResult  insertionSortBicyclesByPrice() {
        Long startTime = System.nanoTime();

        List<Bicycle> bicycleList = getBicycleList();
        int n = bicycleList.size();

        for (int i = 1; i < n; i++) {
            Bicycle key = bicycleList.get(i);
            int j = i - 1;

            if (bicycleList.get(j).getPrice() <= key.getPrice()) {
                continue;
            }

            while (j >= 0 && bicycleList.get(j).getPrice() > key.getPrice()) {
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
    public ExecutionResult mergeSortBicyclesByPrice() {
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
            if (leftList.get(i).getPrice() <= rightList.get(j).getPrice()) {
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

    // Sorting 4 - Tim Sort
    private static final int RUN = 32;
    public ExecutionResult timSortBicyclesByPrice() {
        long startTime = System.nanoTime();

        List<Bicycle> bicycleList = getBicycleList();
        timSort(bicycleList, bicycleList.size());

        long endTime = System.nanoTime();
        long durationSeconds = endTime - startTime;

        return new ExecutionResult(bicycleList, durationSeconds);
    }

    // Timsort implementation
    private void timSort(List<Bicycle> list, int n) {
        // Step 1: Apply insertion sort to small chunks (size <= RUN)
        for (int i = 0; i < n; i += RUN) {
            insertionSort(list, i, Math.min((i + RUN - 1), (n - 1)));
        }

        // Step 2: Merge sorted runs
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge2(list, left, mid, right);
                }
            }
        }
    }

    // Insertion sort for small chunks
    private void insertionSort(List<Bicycle> list, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Bicycle key = list.get(i);
            int j = i - 1;

            // Move elements that are greater than key
            while (j >= left && list.get(j).getPrice() > key.getPrice()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // Merge function to merge two sorted runs
    private void merge2(List<Bicycle> list, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // Temporary arrays to hold the data
        List<Bicycle> leftList = new ArrayList<>(len1);
        List<Bicycle> rightList = new ArrayList<>(len2);

        for (int i = 0; i < len1; i++) {
            leftList.add(list.get(left + i));
        }
        for (int j = 0; j < len2; j++) {
            rightList.add(list.get(mid + 1 + j));
        }

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftList.get(i).getPrice() <= rightList.get(j).getPrice()) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftList, if any
        while (i < len1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of rightList, if any
        while (j < len2) {
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
