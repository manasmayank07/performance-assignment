// Inversions.java

public class Inversions {
    public static long count(int[] a) {
        int[] aux = new int[a.length];
        return sortAndCount(a, aux, 0, a.length - 1);
    }

    private static long sortAndCount(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        long count = 0;
        count += sortAndCount(a, aux, lo, mid);
        count += sortAndCount(a, aux, mid + 1, hi);
        count += mergeAndCount(a, aux, lo, mid, hi);
        return count;
    }

    private static long mergeAndCount(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        long count = 0;
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
                count += (mid - i + 1);
            } else {
                a[k] = aux[i++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
