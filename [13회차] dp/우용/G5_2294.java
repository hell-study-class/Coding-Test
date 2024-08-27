import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        int[] arr = new int[target + 1];
        Arrays.fill(arr, Integer.MAX_VALUE - 1);
        arr[0] = 0;

        for(int i = 0; i < n;i++){
            for(int j = coins[i]; j <= target; j++){
                arr[j] = Math.min(arr[j],arr[j-coins[i]] + 1);
            }
        }
        int result = 0;
        if(arr[target] == Integer.MAX_VALUE - 1){
            result = -1;
        }else{
            result = arr[target];
        }
        System.out.println(result);
    }
}