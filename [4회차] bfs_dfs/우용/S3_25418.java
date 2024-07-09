package com.yukgaejang;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int k = sc.nextInt();

        Queue<int[]> que = new LinkedList<>();

        int[] visited = new int[k+1];
        que.add(new int[]{a,0});

        visited[a] = 1;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0] == k){
                System.out.println(cur[1]);
                return;
            }
            if(cur[0] *2 <= k){
                visited[cur[0]*2] = 1;
                que.add(new int[]{cur[0]*2, cur[1]+1});
            }
            if (visited[cur[0]+1] == 0){
                que.add(new int[]{cur[0]+1, cur[1]+1});
            }
        }
    }
}