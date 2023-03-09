package com.innowise.factory.sort;

import java.util.Comparator;
import java.util.List;

public interface Sortable {
     <T> List<T> sort(List<T> list, Comparator<T> comparator);
}
