import java.util.Comparator;
import java.util.List;

/* INSERTION SORT - O(N^2) */

public class InsertionSort extends SortingAlgorithm{
    @Override
    public <T extends Comparable<T>> void sort(List<T> input, Comparator<T> comparator) {
        for(int i = 1; i < input.size(); i++){
            for(int j = i; j > 0 && comparator.compare(input.get(j), input.get(j-1)) < 0; j--){
                Util.swap(input, j, j-1);
                delay();
            }
        }
        this.sorted = true;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] input, Comparator<T> comparator) {
        for(int i = 1; i < input.length; i++){
            for(int j = i; j > 0 && comparator.compare(input[j], input[j-1]) < 0; j--){
                Util.swap(input, j, j-1);
                delay();
            }
        }
        this.sorted = true;
    }
}
