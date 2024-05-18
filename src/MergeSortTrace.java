import java.util.Arrays;

public class MergeSortTrace {

    public static void main(String[] args) {
        int[] array = {9, 0, 8, 3, 7, 1, 4};
        System.out.println("Initial Array: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1, 1);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right, int level) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, level + 1);
            mergeSort(array, mid + 1, right, level + 1);
            merge(array, left, mid, right, level);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int level) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

        printArrayWithLevel(array, left, right, level);
    }

    // Method to print array with indentation based on the level of recursion
    public static void printArrayWithLevel(int[] array, int left, int right, int level) {
        System.out.print(" ".repeat(level - 1) + level + ": ");
        for (int i = left; i <= right; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
