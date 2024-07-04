package backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            int rank = 1;

            for(int j=0; j<n; j++){
                if(map[i][0] < map[j][0] && map[i][1] < map[j][1]){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
