import java.util.*;

public class MergeSort {
    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];

        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
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

        mergeSort(arr, 0, n - 1);

        long T2 = System.nanoTime();

        System.out.print("\nSorted Array : ");
        for (int x : arr) System.out.print(x + " ");

        System.out.println("\nTime : " + (T2 - T1));
    }
}
