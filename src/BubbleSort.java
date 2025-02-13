import java.util.Comparator;
import java.util.List;

/* BUBBLE SORT - O(N^2) */

public class BubbleSort extends SortingAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(List<T> input, Comparator<T> comparator) {
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for (int i = 0; i < input.size() - 1; i++) {
                if (comparator.compare(input.get(i), input.get(i + 1)) > 0) {
                    Util.swap(input, i, i+1);
                    swapped = true;
                    delay();
                }
            }
        }
        this.sorted = true;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] input, Comparator<T> comparator) {
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (comparator.compare(input[i], input[i+1]) > 0) {
                    Util.swap(input, i, i+1);
                    swapped = true;
                    delay();
                }
            }
        }
        this.sorted = true;
    }
}
