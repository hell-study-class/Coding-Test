import java.util.*;
import java.io.*;

public class Main{

    public static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i ++){

            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(combi(r,n)).append("\n");
        }

        System.out.println(sb);

    }
    public static int combi(int n, int r){
        if(dp[n][r] > 0) {
            return dp[n][r];
        }
        if(n == r || r == 0){
            return 1;
        }

        return dp[n][r] = combi(n-1, r-1)+combi(n-1,r);
    }
}