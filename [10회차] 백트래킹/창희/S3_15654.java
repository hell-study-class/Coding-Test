package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15654 {
    static int[] arr;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int[] result = new int[m];
        boolean[] visited = new boolean[n];
        backtrack(result, 0, visited);
    }
    public static void backtrack(int[] result, int depth, boolean[] visited){
        if(depth == m){
            for(int i : result){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                result[depth] = arr[i];
                visited[i] = true;
                backtrack(result, depth+1, visited);
                visited[i] = false;
            }
        }
    }
}
