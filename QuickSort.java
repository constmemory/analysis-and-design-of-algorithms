import java.util.*;

public class QuickSort {
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * 100);

        System.out.print("\nInitial Array : ");
        for (int x : arr) System.out.print(x + " ");

        System.out.println("\nArray after each pass :");

        long T1 = System.nanoTime();

        quickSort(arr, 0, n - 1);

        long T2 = System.nanoTime();

        System.out.print("\nSorted Array : ");
        for (int x : arr) System.out.print(x + " ");

        System.out.println("\nTime : " + (T2 - T1));
    }
}
