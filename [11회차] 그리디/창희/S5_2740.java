package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] b = new int[m][k];
        for (int i = 0; i < m; i++) {
            b[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] result = new int[n][k];
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                for(int t=0; t<m; t++){
                   result[i][j] += (a[i][t] * b[t][j]);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<k-1; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println(result[i][k-1]);
        }
    }

}
