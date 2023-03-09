package com.innowise.factory.sort;
import java.util.Comparator;
import java.util.List;

public class HeapSort implements Sortable {
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        int listSize = list.size();

        for (int i = listSize / 2 - 1; i >= 0; i--) {
            heapify(list, listSize, i, comparator);
        }

        T temp;
        for (int i = listSize - 1; i >= 0; i--) {
            temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            heapify(list, i, 0, comparator);
        }
        return list;
    }

    private static <T> void heapify(List<T> list, int n, int i, Comparator<T> comparator) {
        int largestIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < n && comparator.compare(list.get(leftIndex), list.get(largestIndex)) > 0) {
            largestIndex = leftIndex;
        }

        if (rightIndex < n && comparator.compare(list.get(rightIndex), list.get(largestIndex)) > 0) {
            largestIndex = rightIndex;
        }

        if (largestIndex != i) {
            T temp = list.get(i);
            list.set(i, list.get(largestIndex));
            list.set(largestIndex, temp);

            heapify(list, n, largestIndex, comparator);
        }
    }
}
