package factory.sort;

import java.util.Comparator;
import java.util.List;

public interface Sort {
    <T> void sort(List<T> list, Comparator<T> comparator);
}
