import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n, capacity, maxValue;
        
        System.out.print("Enter n : ");
        n = sc.nextInt();
        
        System.out.print("Enter capacity : ");
        capacity = sc.nextInt();
        
        int weight[] = new int[n + 1];
        int value[] = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            System.out.print("Enter value " + i + " : ");
            value[i] = sc.nextInt();
            
            System.out.print("Enter weight " + i + " : ");
            weight[i] = sc.nextInt();
        }
        
        int v[][] = new int[n + 1][capacity + 1];
        
        for(int j = 0; j <= capacity; j++){
            v[0][j] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= capacity; j++){
                
                if(weight[i] <= j){
                    v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i]] + value[i]);
                }
                else{
                    v[i][j] = v[i - 1][j];
                }
            }
        }
        
        System.out.println("\nDynamic Programming Table : ");
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= capacity; j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nMaximum Value : " + v[n][capacity]);
        
        System.out.println("\nSelected values : ");
        
        int i = n;
        int j = capacity;
        
        while(i > 0 && j > 0){
            if(v[i][j] != v[i-1][j]){
                System.out.println(value[i]);
                j = j - weight[i];
            }
            i--;
        }
        
    }
}
