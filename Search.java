import java.util.*;

public class Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, key, i;
        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for(i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        key = sc.nextInt();

        int pos1 = -1;
        for(i = 0; i < n; i++) {
            if(arr[i] == key) {
                pos1 = i;
                break;
            }
        }

        if(pos1 != -1)
            System.out.println("Linear Search: Element found at position " + (pos1 + 1));
        else
            System.out.println("Linear Search: Element not found");

        Arrays.sort(arr);

        int low = 0, high = n - 1, mid;
        int pos2 = -1;

        while(low <= high) {
            mid = (low + high) / 2;

            if(arr[mid] == key) {
                pos2 = mid;
                break;
            }
            else if(arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if(pos2 != -1)
            System.out.println("Binary Search: Element found at position " + (pos2 + 1) + " (in sorted array)");
        else
            System.out.println("Binary Search: Element not found");

        sc.close();
    }
}
