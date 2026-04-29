import java.util.*;

public class MakingChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, N, result;
        System.out.print("Enter Amount : ");
        N = sc.nextInt();
        System.out.print("Enter no. of Denominations : ");
        n = sc.nextInt();
        
        int d[] = new int[n];
        System.out.println("Enter Denominations");
        for(int i = 0; i < n; i++){
            System.out.print("Denomination " + (i + 1) + " : ");
            d[i] = sc.nextInt();
        }
        
        int c[][] = new int[n][N + 1];
        
        for(int i = 0; i < n; i++){
            c[i][0] = 0;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= N; j++){
                if(i == 0 && j < d[i]) c[i][j] = Integer.MAX_VALUE - 1;
                else if(i == 0) c[i][j] = 1 + c[i][j - d[i]];
                else if(j < d[i]) c[i][j] = c[i - 1][j];
                else c[i][j] = Math.min(c[i - 1][j], 1 + c[i][j - d[i]]);
            }
        }
               
        System.out.println("\nDynamic Programming Table : ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= N; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        
        if(c[n - 1][N] >= Integer.MAX_VALUE - 1){
            System.out.println("Change not possible");
        } 
        else{
        System.out.println("\nNumber of coins required : " + c[n - 1][N]);
        }
        
        System.out.print("\nCoins required : ");
        
        int i = n - 1;
        int j = N;

        while(j > 0 && i >= 0){
            if(i == 0){
                System.out.print(d[i] + " ");
                j = j - d[i];
            }
            else if(c[i][j] == c[i - 1][j]){
                i = i - 1;
            }
            else{
                System.out.print(d[i] + " ");
                j = j - d[i];
            }
        }
        System.out.println();
    }
}
