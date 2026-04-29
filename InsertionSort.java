import java.util.*;

public class InsertionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        System.out.print("\nInitial Array : ");
        for (int x : arr) System.out.print(x + " ");

        long T1 = System.nanoTime();

        System.out.println("\nArray after each pass :");

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            for (int x : arr) System.out.print(x + " ");
            System.out.println();
        }

        long T2 = System.nanoTime();

        System.out.print("\nSorted Array : ");
        for (int x : arr) System.out.print(x + " ");

        System.out.println("\nTime : " + (T2 - T1));
    }
}
