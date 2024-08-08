package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15657 {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] result = new int[m];
        backtrack(result, 0, 0);
    }
    public static void backtrack(int[] result, int depth, int start){
        if(depth == m){
            for(int i: result){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<n; i++){
            result[depth] = arr[i];
            backtrack(result, depth+1, i);
            result[depth] = 0;
        }
    }
}
