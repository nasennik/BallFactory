package com.innowise.factory.sort;

import java.util.function.Function;

public enum SortType {
    MERGE_SORT(new MergeSort()),
    QUICK_SORT(new QuickSort()),
    HEAP_SORT(new HeapSort());
    final Sortable sortable;

    SortType(Sortable sortable) {
        this.sortable = sortable;
    }

    public Sortable getSortable() {
        return sortable;
    }
}
