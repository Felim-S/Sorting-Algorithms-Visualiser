import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public abstract class SortingAlgorithm implements Comparable<SortingAlgorithm> {
    public abstract <T extends Comparable<T>> void sort(final List<T> input, final Comparator<T> comparator);
    public abstract <T extends Comparable<T>> void sort(final T[] input, final Comparator<T> comparator);
    public static final int SIZE = 10000;
    public static final int DELAY = 20;

    public boolean sorted = false;

    /**
     * Delays the sorting algorithm by a constant value (in ms)
     * in order to display the sorting algorithm step-by-step
     */
    protected void delay(){
        try{
            Thread.sleep(DELAY);
            SwingUtilities.invokeLater(() -> Panel.getInstance().repaint());
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    /**
     * Used in order to compare algorithms based off runtime
     *
     * @param o : The sorting algorithm to be compared against this
     * @return int : 1 if runtimeA < runtimeB, -1 if runtimeA > runtimeB
     *               0 if runtimeA == runtimeB
     */
    @Override
    public int compareTo (SortingAlgorithm o) {
        Random random = new Random();
        Integer[] array = new Integer[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(SIZE);
        }

        long start = System.currentTimeMillis();
        this.sort(array, Comparator.comparing(Integer::intValue));
        long runtimeA = System.currentTimeMillis() - start;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(SIZE);
        }

        start = System.currentTimeMillis();
        o.sort(array, Comparator.comparing(Integer::intValue));
        long runtimeB = System.currentTimeMillis() - start;

        if(runtimeA == runtimeB){
            return 0;
        }
        return runtimeA < runtimeB ? 1 : -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}