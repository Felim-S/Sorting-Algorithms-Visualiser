import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort extends SortingAlgorithm{
    @Override
    public <T extends Comparable<T>> void sort(final T[] data, final Comparator<T> comparator) {
        Util.arrayShuffle(data);
        qsort(data,0,data.length-1,comparator);
        this.sorted = true;
    }

    @Override
    public <T extends Comparable<T>> void sort(final List<T> data, final Comparator<T> comparator) {
        Collections.shuffle(data);
        qsort(data,0,data.size()-1,comparator);
        this.sorted = true;
    }

    private static <T extends Comparable<T>> void qsort(T[] a, int low, int high, final Comparator<T> comparator) {
        if(high <= low){
            return;
        }
        int j = partition(a,low,high,comparator);
        qsort(a,low,j-1,comparator);
        qsort(a,j+1,high,comparator);
    }

    private static <T extends Comparable<T>> void qsort(List<T> a, int low, int high, final Comparator<T> comparator) {
        if(high <= low){
            return;
        }
        int j = partition(a,low,high,comparator);
        qsort(a,low,j-1,comparator);
        qsort(a,j+1,high,comparator);
    }

    private static <T extends Comparable<T>> int partition(T[] a, int low, int high, Comparator<T> comparator)
    {
        int i = low, j = high + 1;
        while (true)
        {
            while (comparator.compare(a[++i], a[low]) <= 0){
                if (i == high) break;
            }

            while (comparator.compare(a[low], a[--j]) <= 0){
                if (j == low) break;
            }
            if (i >= j) break;
            Util.swap(a, i, j);
        }
        Util.swap(a, low, j);
        return j;
    }

    private static <T extends Comparable<T>> int partition(List<T> a, int low, int high, Comparator<T> comparator)
    {
        int i = low, j = high + 1;
        while (true)
        {
            while (comparator.compare(a.get(++i), a.get(low)) <= 0){
                if (i == high) break;
            }

            while (comparator.compare(a.get(low), a.get(--j)) <= 0){
                if (j == low) break;
            }
            if (i >= j) break;
            Util.swap(a, i, j);
        }
        Util.swap(a, low, j);
        return j;
    }
}
