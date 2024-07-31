package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15650 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] result = new int[m];
        boolean[] visited = new boolean[n];
        backtrack(result, visited, 0, 0);
    }
    public static void backtrack(int[] result, boolean[] visited,int s, int depth) {
        if(depth == m){
            for(int num : result){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=s; i<n; i++){
            if(!visited[i]){
                result[depth] = i+1;
                visited[i] = true;
                if(depth == m-1){
                    backtrack(result, visited, i, depth+1);
                }else{
                    backtrack(result, visited, i+1 ,depth+1);
                }
            }
            visited[i] = false;
        }

    }
}
