package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class confetti_2563 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] canvas = new int[100][100];

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=0; j < 10; j++) {
                for(int k=0; k<10; k++) {
                    canvas[x+j][y+k]++;
                    if(canvas[x+j][y+k] == 1) {
                        result++;
                    }

                }
            }
        }
        System.out.println(result);
    }
}
