package factory.sort;

import factory.sort.Sort;

import java.util.*;

public class QuickSort implements Sort {


    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        quickSort(list, 0, list.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> list, int left, int right, Comparator<T> comparator) {
        if (left < right) {
            int pivotIndex = partition(list, left, right, comparator);
            quickSort(list, left, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, right, comparator);
        }
    }

    private static <T> int partition(List<T> list, int left, int right, Comparator<T> comparator) {
        T pivot = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, right);
        return i + 1;
    }
}
