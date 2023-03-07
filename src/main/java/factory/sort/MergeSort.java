package factory.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements Sort {

    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        if (list.size() > 1) {
            int mid = list.size() / 2;

            List<T> left = list.subList(0, mid);
            List<T> right = list.subList(mid, list.size());

            sort(left, comparator);
            sort(right, comparator);

            merge(list, left, right, comparator);
        }
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
