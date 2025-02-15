import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* Reference: https://www.geeksforgeeks.org/sleep-sort-king-laziness-sorting-sleeping/ */
public class SleepSort extends SortingAlgorithm{
    public static final int SLEEPDELAY = 100;

    @Override
    public <T extends Comparable<T>> void sort(List<T> input, Comparator<T> comparator) {
        ArrayList<Thread> threads = new ArrayList<>();  // Create an ArrayList to hold threads

        for (T num : input) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep((Integer) num * SLEEPDELAY);  // Sleep for 'num' milliseconds
                    input.set((Integer) num-1,num);  // Set index 'num' to num after num milliseconds
                    delay();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            threads.add(thread); // Add the thread to the ArrayList
            thread.start(); // Start the thread
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.sorted = true;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] input, Comparator<T> comparator) {
        ArrayList<Thread> threads = new ArrayList<>();  // Create an ArrayList to hold threads

        for (T num : input) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep((Integer) num * SLEEPDELAY);  // Sleep for 'num' milliseconds
                    input[(Integer) num] = num;  // Set index 'num' to num after num milliseconds
                    delay();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            threads.add(thread); // Add the thread to the ArrayList
            thread.start(); // Start the thread
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.sorted = true;
    }
}
