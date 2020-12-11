package hu.company.climbing.measure.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class MeasurementCalculator {
    private List<Integer> steepestAscent;
    private List<Integer> steepestDescent;
    private List<Integer> datas;


    public MeasurementCalculator(List<Integer> datas) {
        this.steepestAscent = new ArrayList<>();
        this.steepestDescent = new ArrayList<>();
        this.datas = datas;
    }

    public List<Integer> getSteepestAscent() {
        return steepestAscent;
    }

    public List<Integer> getSteepestDescent() {
        return steepestDescent;
    }

    public void calculate() {
        ListIterator<Integer> listIterator = datas.listIterator();
        Integer steepestAscentGap = 0;
        Integer steepestDescentGap = 0;
        Integer lastCheckedNumber = null;
        while (listIterator.hasNext()) {
            Integer data1 = lastCheckedNumber != null ? lastCheckedNumber : listIterator.next();
            if (!listIterator.hasNext()) {
                break;
            }
            Integer data2 = listIterator.next();
            lastCheckedNumber = data2;
            List<Integer> datasForCheck = Arrays.asList(data1, data2);

            if (data1 < data2) {
                Integer gap = calculateSteepestAscent(datasForCheck);
                if (steepestAscentGap < gap) {
                    steepestAscent = new ArrayList<>(datasForCheck);
                    steepestAscentGap = gap;
                }
            } else if (data1 > data2) {
                Integer gap = calculateSteepestDescent(datasForCheck);
                if (steepestDescentGap < gap) {
                    steepestDescent = new ArrayList<>(datasForCheck);
                    steepestDescentGap = gap;
                }
            }
        }
    }

    private Integer calculateSteepestAscent(List<Integer> actualAscent) {
        return actualAscent.get(1) - actualAscent.get(0);
    }

    private Integer calculateSteepestDescent(List<Integer> actualDescent) {
        return actualDescent.get(0) - actualDescent.get(1);
    }
}
