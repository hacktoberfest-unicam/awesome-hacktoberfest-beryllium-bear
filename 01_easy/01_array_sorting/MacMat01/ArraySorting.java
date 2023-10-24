import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraySorting {

    private static int[] arrayToSort = {1, 4, 5, 2, 9, 12, 3};

    public static void main(String[] args) {

        arrayToSort = Arrays.stream(arrayToSort).sorted().toArray();

        for (int i : arrayToSort) {
            System.out.println(i);
        }
    }
}