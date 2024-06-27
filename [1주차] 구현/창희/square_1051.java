package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class square_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            map[i] = Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).toArray();
        }
        int size = n > m ? m : n;

        while(size > 1) {
            for(int i=0; i<=n-size; i++) {
                for(int j=0; j<=m-size; j++) {
                    int len = map[i][j];
                    if(len == map[i][j+size-1]
                            && len == map[i+size-1][j]
                            && len == map[i+size-1][j+size-1]) {
                        System.out.println(size * size);
                        return;
                    }
                }
            }
            size--;
        }
        System.out.println(size * size);
    }
}
