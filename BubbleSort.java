import java.util.*;

public class BubbleSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size : ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        System.out.print("\nInitial Array : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        long T1 = System.nanoTime();

        System.out.println("\nArray after each pass :");

        for (int i = 0; i < n - 1; i++) {
            int swapped = 0;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }

            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();

            if (swapped == 0) {
                break;
            }
        }

        long T2 = System.nanoTime();

        System.out.print("\nSorted Array : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nTime : " + (T2 - T1));
    }
}
