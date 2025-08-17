import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort extends SortingAlgorithm{

    private <T extends Comparable<T>> void merge(T[] data, T[] l, T[] r, int left, int right, final Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l[i],r[j]) <= 0) {
                data[k++] = l[i++];
            }
            else {
                data[k++] = r[j++];
            }
            Panel.getInstance().repaint();
            delay();
        }
        while (i < left){
            data[k++] = l[i++];
            Panel.getInstance().repaint();
            delay();
        }
        while (j < right) {
            data[k++] = r[j++];
            Panel.getInstance().repaint();
            delay();
        }
    }

    private <T extends Comparable<T>> void merge(List<T> data, List<T> l, List<T> r, int left, int right, final Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l.get(i), r.get(j)) <= 0) {
                data.set(k++, l.get(i++));
            }
            else {
                data.set(k++, r.get(j++));
            }
            Panel.getInstance().repaint();
            delay();
        }
        while (i < left){
            data.set(k++, l.get(i++));
            Panel.getInstance().repaint();
            delay();
        }
        while (j < right) {
            data.set(k++, r.get(j++));
            Panel.getInstance().repaint();
            delay();
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(List<T> input, Comparator<T> comparator) {
        if (input.size() < 2){
            return;
        }
        int mid = input.size() / 2;
        List<T> l = new ArrayList<>();
        List<T> r = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            l.addFirst(input.get(i));
        }
        for (int i = mid; i < input.size(); i++) {
            r.addFirst(input.get(i));
        }
        sort(l, comparator);
        sort(r, comparator);
        merge(input, l, r, mid, input.size() - mid, comparator);
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] input, Comparator<T> comparator) {
        if (input.length < 2){
            return;
        }
        int mid = input.length / 2;
        T[] l = (T[]) new Comparable[mid];
        T[] r = (T[]) new Comparable[input.length - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = input[i];
        }
        for (int i = mid; i < input.length; i++) {
            r[i - mid] = input[i];
        }
        sort(l, comparator);
        sort(r, comparator);
        merge(input, l, r, mid, input.length - mid, comparator);
    }
}
