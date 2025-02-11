import java.util.*;

public class Util {
    public static <T extends Comparable<T>> void arrayShuffle(final T[] input){
        /* Reference: https://www.digitalocean.com/community/tutorials/shuffle-array-java */
        Random rand = new Random();
        for(int i = 0; i < input.length; i++){
            int randomIndexToSwap = rand.nextInt(input.length);
            T temp = input[randomIndexToSwap];
            input[randomIndexToSwap] = input[i];
            input[i] = temp;
        }
    }

    public static <T extends Comparable<T>> void swap(List<T> input, int i, int j){
        T temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }

    public static <T extends Comparable<T>> void swap(T[] input, int i, int j) {
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
