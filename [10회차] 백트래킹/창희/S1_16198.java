package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_16198 {
    static int n;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        backtrack(0, 0, arr);
        System.out.println(max);
    }
    public static void backtrack(int depth, int result, ArrayList<Integer> arr){
        if(depth == n-2){
            if(result > max){
                max = result;
            }
            return;
        }

        for(int i= 1; i< arr.size()-1; i++){
            result += arr.get(i-1) * arr.get(i+1);
            int temp = arr.get(i);
            arr.remove(i);
            backtrack(depth+1, result, arr);
            arr.add(i, temp);
            result -= arr.get(i-1) * arr.get(i+1);
        }
    }
}
