package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15649 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] result = new int[m];
        boolean[] visited = new boolean[n];
        backtrack(result, 0, visited);

    }
    public static void backtrack(int[] result, int depth, boolean[] visited){
        if(depth == m){
            for(int i=0; i<m; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return ;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            result[depth] = i+1;
            visited[i] = true;
            backtrack(result,depth+1, visited);
            visited[i] = false;
        }

    }
}
