import java.util.*;

public class SelectionSort {
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

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            for (int x : arr) System.out.print(x + " ");
            System.out.println();
        }

        long T2 = System.nanoTime();

        System.out.print("\nSorted Array : ");
        for (int x : arr) System.out.print(x + " ");

        System.out.println("\nTime : " + (T2 - T1));
    }
}
