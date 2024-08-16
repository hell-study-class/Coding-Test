package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1149 {
    static int[][] dp;
    static int[][] cost;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cost = new int[n][3];
        dp = new int[n][3];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0] = cost[0];
        for(int j=1; j<n; j++){
            for(int i=0; i<3; i++){
                dp[j][i] = Math.min(dp[j-1][(i+1)%3], dp[j-1][(i+2)%3]) + cost[j][i];
            }
        }
        int min = dp[n-1][0];
        for(int i=0; i<2; i++){
           if(min > dp[n-1][i+1]){
               min = dp[n-1][i+1];
           }
        }
        System.out.println(min);
    }
}
