import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* BOGOSORT - O(N*N!) */

public class Bogosort extends SortingAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(List<T> input, Comparator<T> comparator) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            // Randomly shuffle the array
            Collections.shuffle(input);
            delay();
            // Is it sorted? If so, return!
            for (int i = 0; i < input.size() - 1; i++) {
                if (comparator.compare(input.get(i), input.get(i + 1)) > 0) {
                    sorted = false;
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>>void sort (T[]input, Comparator < T > comparator){
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            // Randomly shuffle the array
            Util.arrayShuffle(input);
            delay();
            // Is it sorted? If so, return!
            for (int i = 0; i < input.length - 1; i++) {
                if (comparator.compare(input[i], input[i + 1]) > 0) {
                    sorted = false;
                }
            }
        }
    }
}