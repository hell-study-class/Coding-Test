package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2503 {
    static int[] numbers;
    static int[][] map;
    static int n;
    static int[] result = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        map = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            check(map[i][0], map[i][1], numbers[i]);
        }

        for(int i = 123; i<988; i++){
            int[] digits = new int[3];
            for(int j=0; j<3; j++){
                digits[2-j] = i % 10;
                i /= 10;
            }

        }
    }
    public static void check(int s, int b, int num){
        if(s == 0 && b == 0){
            return;
        }


    }
}
