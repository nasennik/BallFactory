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

    private static <T> void merge(List<T> list, List<T> left, List<T> right, Comparator<T> comparator) {
        int i = 0;
        int j = 0;
        List<T> result = new ArrayList<>(list.size());

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        for (int k = 0; k < result.size(); k++) {
            list.set(k, result.get(k));
        }
    }

}
