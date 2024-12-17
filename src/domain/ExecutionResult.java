package domain;

import java.util.List;

public class ExecutionResult {
    private final List<Bicycle> bicycles;
    private final long durationSeconds;

    public ExecutionResult(List<Bicycle> bicycles, long durationSeconds) {
        this.bicycles = bicycles;
        this.durationSeconds = durationSeconds;
    }

    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    public double getDurationSeconds() {
        return durationSeconds;
    }
}
