package com.yukgaejang;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n,s ;
    public static int[] arr;
    public static boolean[] visit;
    public static ArrayList<Integer> selected = new ArrayList<>();
    public static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0;  i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0,0);
        if(s==0){
            System.out.println(cnt-1);
            return;
        }
        System.out.println(cnt);
    }

    private static void recursive(int index, int sum) {
        if(index == n){
            if(sum == s){
                cnt++;
            }
            return;
        }
        recursive(index+1, sum+arr[index]);
        recursive(index+1, sum);
    }
}