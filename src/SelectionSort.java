import java.util.Comparator;
import java.util.List;

/* SELECTION SORT - O(N^2) */

public class SelectionSort extends SortingAlgorithm{
    @Override
    public <T extends Comparable<T>> void sort(List<T> input, Comparator<T> comparator) {
        int minIndex;
        for(int i = 0; i < input.size() - 1; i++){
            minIndex = i;
            // Find the smallest element (min)
            for(int j = i + 1; j < input.size(); j++){
                if(input.get(j).compareTo(input.get(minIndex)) < 0){
                    minIndex = j;
                }
            }
            // If the min value has changed (is not equal to i), swap i and min
            if(minIndex != i){
                Util.swap(input, i, minIndex);
                delay();
            }
        }
        this.sorted = true;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] input, Comparator<T> comparator) {
        int minIndex;
        for(int i = 0; i < input.length - 1; i++){
            minIndex = i;
            // Find the smallest element (min)
            for(int j = i + 1; j < input.length; j++){
                if(input[j].compareTo(input[minIndex]) < 0){
                    minIndex = j;
                }
            }
            // If the min value has changed (is not equal to i), swap i and min
            if(minIndex != i){
                Util.swap(input, i, minIndex);
                delay();
            }
        }
        this.sorted = true;
    }
}
