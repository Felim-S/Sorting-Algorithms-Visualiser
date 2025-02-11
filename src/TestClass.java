import java.util.*;

public class TestClass {

    public static final int SIZE = 1000;

    public static void main(String[] args) {
        Random random = new Random();

        Integer[] arr1 = new Integer[SIZE];
        Double[] arr2 = new Double[SIZE];
        Character[] arr3 = new Character[SIZE];

        List<Integer> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        List<Character> list3 = new ArrayList<>();

        for(int i = 0; i < arr1.length; i++){
            arr1[i] = random.nextInt(SIZE);
            list1.add(random.nextInt(SIZE));
            arr2[i] = random.nextDouble(SIZE);
            list2.add(random.nextDouble(SIZE));
            arr3[i] = (char) (random.nextInt() % 26 + 60);
            list3.add((char) (random.nextInt(26) + 60));
        }

        /* AVAILABLE ALGORITHMS */

        Bogosort bogosort = new Bogosort();
        SelectionSort selectionSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        ShellSort shellSort = new ShellSort();

        /* SELECTED ALGORITHM */
        SortingAlgorithm algorithm = shellSort;

        /* Integer Collections */

        runTest(list1, algorithm);

        runTest(arr1, algorithm);

        /* Double Collections */

        runTest(list2, algorithm);

        runTest(arr2, algorithm);

        /* Character Collections */

        runTest(list3, algorithm);

        runTest(arr3, algorithm);
    }

    public static <T extends Comparable<T>> void runTest(final List<T> input, final SortingAlgorithm algorithm) {
        System.out.println("List: " + input);
        long start = System.currentTimeMillis();
        algorithm.sort(input, Comparator.<T>naturalOrder());
        long end = System.currentTimeMillis();
        System.out.println("SORTED: " + input);
        System.out.println("Time taken: " + (end - start) + "ms");
    }

    public static <T extends Comparable<T>> void runTest(final T[] input, final SortingAlgorithm algorithm) {
        System.out.println("Array: " + Arrays.toString(input));
        long start = System.currentTimeMillis();
        algorithm.sort(input, Comparator.<T>naturalOrder());
        long end = System.currentTimeMillis();
        System.out.println("SORTED: " + Arrays.toString(input));
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
