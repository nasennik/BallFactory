package com.innowise.factory.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements Sortable {

    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        if (list.size() > 1) {
            int midIndex = list.size() / 2;

            List<T> leftList = list.subList(0, midIndex);
            List<T> rightList = list.subList(midIndex, list.size());

            sort(leftList, comparator);
            sort(rightList, comparator);

            merge(list, leftList, rightList, comparator);
        }
        return list;
    }

    private static <T> void merge(List<T> list, List<T> leftList, List<T> rightList, Comparator<T> comparator) {
        int counterLeft = 0;
        int counterRight = 0;
        List<T> result = new ArrayList<>(list.size());

        while (counterLeft < leftList.size() && counterRight < rightList.size()) {
            if (comparator.compare(leftList.get(counterLeft), rightList.get(counterRight)) <= 0) {
                result.add(leftList.get(counterLeft));
                counterLeft++;
            } else {
                result.add(rightList.get(counterRight));
                counterRight++;
            }
        }

        while (counterLeft < leftList.size()) {
            result.add(leftList.get(counterLeft));
            counterLeft++;
        }

        while (counterRight < rightList.size()) {
            result.add(rightList.get(counterRight));
            counterRight++;
        }

        for (int k = 0; k < result.size(); k++) {
            list.set(k, result.get(k));
        }
    }

}
