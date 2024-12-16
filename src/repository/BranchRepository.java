package repository;

import domain.Bicycle;
import domain.Branch;

import java.util.HashMap;
import java.util.Map;

public class BranchRepository {
    private final Map<Integer, Branch> branches = new HashMap<>();

    public void saveBranch(Branch branch) {
        branches.put(branch.getId(), branch);
    }

    public Map<Integer, Branch> getBranches() {
        return branches;
    }
}
