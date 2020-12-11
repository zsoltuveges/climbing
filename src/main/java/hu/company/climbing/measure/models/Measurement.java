package hu.company.climbing.measure.models;

import java.util.List;

public class Measurement {
    private List<Integer> climbingMeasurements;

    public Measurement() {
    }

    public Measurement(List<Integer> climbingMeasurements) {
        this.climbingMeasurements = climbingMeasurements;
    }

    public List<Integer> getClimbingMeasurements() {
        return climbingMeasurements;
    }

    public void setClimbingMeasurements(List<Integer> climbingMeasurements) {
        this.climbingMeasurements = climbingMeasurements;
    }
}
