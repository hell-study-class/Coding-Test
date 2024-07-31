package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15651 {
    static int n, m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        int[] result = new int[m];
        backtrack(result, 0);
        System.out.println(sb);
    }
    public static void backtrack(int[] result, int depth){
        if(depth == m){
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            result[depth] = i+1;
            backtrack(result, depth+1);
        }
    }
}
