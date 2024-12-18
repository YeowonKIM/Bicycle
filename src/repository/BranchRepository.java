package repository;

import domain.Branch;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash map of key-value (id - branch entity) as a data structure
 */
public class BranchRepository {
    private final Map<Integer, Branch> branches = new HashMap<>();

    public void saveBranch(Branch branch) {
        branches.put(branch.getId(), branch);
    }

    public Map<Integer, Branch> getBranches() {
        return branches;
    }
}
