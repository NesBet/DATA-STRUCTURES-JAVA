import java.util.Comparator;

public class Searcher<T> {
    public static <T> int binarySearch(T[] array, int arraySize, T key, Comparator<T> comparer) {
        int low = 0;
        int high = arraySize - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compareResult = comparer.compare(array[mid], key);

            if (compareResult < 0) {
                low = mid + 1;
            } else if (compareResult > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int intResult = binarySearch(intArray, intArray.length, 7, Comparator.naturalOrder());
        System.out.println(intResult == 6 ? "PASS" : "FAIL");

        String[] stringArray = {"apple", "banana", "cherry", "date", "elderberry"};
        int stringResult = binarySearch(stringArray, stringArray.length, "cherry", Comparator.naturalOrder());
        System.out.println(stringResult == 2 ? "PASS" : "FAIL");
    }
}
