package com.yukgaejang;
import java.util.*;
import java.io.*;

public class Main {
    public static int n,k;
    public static int[] arr ;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<Integer> permu = new ArrayList<>();
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        recursive(new ArrayList<Integer>(),0);
        System.out.println(permu.size());
    }

    public static void recursive(List<Integer> indexs, int depth){
        if(depth == k){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < list.size(); i++){
                sb.append(list.get(i));
            }
            int num = Integer.parseInt(sb.toString());
            if(!permu.contains(num)){
                permu.add(num);
            }
            return ;
        }

        for(int i = 0; i<arr.length; i++){
            if(!indexs.contains(i)){
                list.add(arr[i]);
                indexs.add(i);
                recursive(indexs, depth+1);
                indexs.remove((Object)i);
                list.remove(list.size()-1);
            }

        }

    }
}