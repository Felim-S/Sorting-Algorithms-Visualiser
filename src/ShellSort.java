import java.util.Comparator;
import java.util.List;

/* ShellSort := O(N^2) */

/*
* References:
* https://en.wikipedia.org/wiki/Shellsort#Computational_complexity
* https://www.physics.muni.cz/~jancely/NM/Procedury/ProcG95/Sort/Sort/Zdroje/ShellsortAnalysis.pdf
* */

public class ShellSort extends SortingAlgorithm{
    @Override
    public <T extends Comparable<T>> void sort(List<T> input, Comparator<T> comparator) {
        int[] gaps = { 1391376, 463792, 198768, 86961, 33936, 13776, 4592,
                1968, 861, 336, 112, 48, 21, 7, 3, 1 };
        for(int gap : gaps){
            for(int i = gap; i < input.size(); i++){
                T temp = input.get(i);
                int j = i;
                while((j >= gap) && (comparator.compare(input.get(j-gap), temp) > 0)){
                    input.set(j, input.get(j-gap));
                    j -= gap;
                    delay();
                }
                input.set(j, temp);
            }
        }
        this.sorted = true;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] input, Comparator<T> comparator) {
        int[] gaps = { 1391376, 463792, 198768, 86961, 33936, 13776, 4592,
                1968, 861, 336, 112, 48, 21, 7, 3, 1 };
        for(int gap : gaps){
            for(int i = gap; i < input.length; i++){
                T temp = input[i];
                int j = i;
                while((j >= gap) && (comparator.compare(input[j-gap], temp) > 0)){
                    input[j] = input[j-gap];
                    j -= gap;
                    delay();
                }
                input[j] = temp;
            }
        }
        this.sorted = true;
    }
}
