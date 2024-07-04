package baeckjoon.weeks2.thursday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_11724 {
    public static int[][] map;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
            map[b-1][a-1] = 1;
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int j=0; j<map.length; j++){
                if(map[cur][j] == 1 && !visited[j]){
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}
