package backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        for(int t=0; t<k; t++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int i= Integer.parseInt(st.nextToken());
            int j= Integer.parseInt(st.nextToken());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            for(int a= i-1; a < x; a++){
                for(int b= j-1; b < y; b++){
                    sum += map[a][b];
                }
            }
            System.out.println(sum);
        }
    }
}
