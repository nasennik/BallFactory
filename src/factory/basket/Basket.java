package factory.basket;

import factory.model.ball.Ball;
import factory.sort.HeapSort;
import factory.sort.MergeSort;
import factory.sort.QuickSort;
import factory.sort.SortType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket<T extends Ball> {

    List<T> balls = new ArrayList<>();

    public Basket() {
    }

    public void addBall(T ball) {
        if (ball != null) {
            balls.add(ball);
        }
    }

    public void removeBall(T ball) {
        balls.remove(ball);
    }

    public List<T> getBalls() {
        return balls;
    }

    public void sort(SortType sortFunction, Comparator<T> comparator) {
        if (comparator != null) {
            switch (sortFunction) {
                case MERGE_SORT:
                    MergeSort mergeSort = new MergeSort();
                    mergeSort.sort(balls, comparator);
                    break;
                case QUICK_SORT:
                    QuickSort quickSort = new QuickSort();
                    quickSort.sort(balls, comparator);
                    break;
                case HEAP_SORT:
                    HeapSort heapSort = new HeapSort();
                    heapSort.sort(balls, comparator);
                    break;
                default:
                    System.out.println("Invalid sort function");
                    break;
            }
        }
    }


}


