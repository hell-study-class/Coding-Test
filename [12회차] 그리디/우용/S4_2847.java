import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for(int i = arr.length-2; i >= 0; i--){
            while(arr[i] >= arr[i+1]){
                arr[i]--;
                ans++;
            }
        }
        System.out.println(ans);
    }
}