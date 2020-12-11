package hu.company.climbing.measure.utils;

import hu.company.climbing.measure.models.Measurement;

import java.util.List;

public class Printer {
    public void printResultsToTheScreen(Measurement measurement, List<Integer> steepestAscend, List<Integer> steepestDescend) {
        System.out.println("Measurement datas: " + measurement.getClimbingMeasurements());
        if (steepestAscend.isEmpty()) {
            System.out.println("There were no ascending datas");
        } else {
            System.out.println("Steepest ascend: " + steepestAscend);
        }
        if (steepestDescend.isEmpty()) {
            System.out.println("There were no descending datas");
        } else {
            System.out.println("Steepest descend: " + steepestDescend);
        }
    }
}
