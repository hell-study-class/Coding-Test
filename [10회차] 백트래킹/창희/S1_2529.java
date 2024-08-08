package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class S1_2529 {
        static String[] str;
        static int k;
        static int[] min_result;
        static int[] max_result;
        static int min = Integer.MAX_VALUE;
        static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        str = br.readLine().split(" ");
        boolean[] visited = new boolean[10];
        min_result = new int[k+1];
        max_result = new int[k+1];
        int[] result = new int[k+1];
        backtrack(result, 0, 0, visited);
        for(int i : max_result)
            System.out.print(i);
        System.out.println();
        for(int i: min_result)
            System.out.print(i);
    }
    public static void backtrack(int[] result, int depth, int s, boolean[] visited){
        if(depth == k+1){
            int l = 1;
            int sum = 0;
            for(int i =k; i>=0; i--){
                sum += result[i] * l;
                l *= 10;
            }
            if(sum > max){
                max = sum;
                max_result = result;
            }
            if(sum < min){
                min = sum;
                min_result = result;
            }
            return ;
        }

        for(int i = 0; i< 10; i++){
            if(depth == 0){
                result[depth] = i;
                visited[i] = true;
                backtrack(result, depth+1, i+1, visited);
                visited[i] = false;
            }else{

            if(Objects.equals(str[depth], "<")){
                if(result[depth-1] < i && !visited[i]){
                    result[depth] = i;
                    visited[i] = true;
                    backtrack(result, depth+1, i+1, visited);
                    visited[i] = false;
                }
            }else if(str[depth].equals(">")){
                if(result[depth-1] > i && !visited[i]){
                    result[depth] = i;
                    visited[i] = true;
                    backtrack(result, depth+1, i+1, visited);
                    visited[i] = false;
                }
            }
            }
        }
    }
}
