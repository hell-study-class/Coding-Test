package com.yukgaejang;
import java.util.*;
import java.io.*;

public class Main {
    public static int n,m;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        recursive( 0);
        System.out.println(sb.toString());
    }

    public static void recursive( int depth){
        if(depth == m){
            for(int i = 0 ; i < list.size(); i++){
                sb.append(list.get(i)+" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i = 1; i<=n;i++){
            list.add(i);
            recursive(depth+1);
            list.remove(list.size()-1);
        }
    }
}