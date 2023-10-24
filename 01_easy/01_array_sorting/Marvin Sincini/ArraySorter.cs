
public class ArraySorter {

    public void Sort(int[] array) {
        QuickSort(array, 0, array.Length - 1);
    }

    //applica ricorsivamente il quicksort partendo dal presupposto
    //che il pilot e' sempre l'ultimo elemento della sequenza
    private void QuickSort(int[] array, int from, int to) {
        if (from < 0 || to > array.Length - 1 || from >= to)
            return;
        int pilot = to;
        for (int i = from; i < pilot; i++) {
            if (array[i] > array[pilot]) {
                PutUp(array, i, pilot);
                pilot--;
            }
        }
        QuickSort(array, from, pilot - 1);
        QuickSort(array, pilot + 1, to);
    }

    //fa scorrere un elemento in posizione p1 in un array finche' si trova
    //in una posizione inferiore a p2
    private void PutUp(int[] array, int p1, int p2) {
        if (p1 < 0 || p2 > array.Length - 1 || p1 >= p2)
            return;
        int item = array[p1];
        array[p1] = array[p1 + 1];
        array[p1 + 1] = item;
        PutUp(array, p1 + 1, p2);

    }

}
