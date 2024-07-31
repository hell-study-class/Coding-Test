package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }
            int[] numbers = new int[k];
            for(int i=0; i<k; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            int[] result = new int[6];
            backtrack(result, numbers, 0, k, 0);
            System.out.println();
        }

    }
    public static void backtrack(int[] result, int[] numbers, int s, int k, int depth){
        if(depth == 6){
            for(int i=0; i<6; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=s; i<k; i++){
            result[depth] = numbers[i];
            backtrack(result, numbers, i+1, k, depth+1);
        }
    }
}
