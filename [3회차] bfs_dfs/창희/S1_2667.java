package baeckjoon.weeks2.thursday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_2667 {
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }
        int count = 0;
        List<Integer> result = new LinkedList<>();
        for(int y=0; y < n; y++){
            for(int x=0; x < n; x++){
                while(!visited[y][x] && map[y][x] == '1'){
                    count++;
                    result.add(bfs(x, y));
                }
            }
        }

        System.out.println(count);
        Collections.sort(result);
        for(int i : result){
            System.out.println(i);
        }
    }
    public static int bfs(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});
        visited[b][a] = true;
        int count = 1;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }
                if(map[ny][nx] > '0' && !visited[ny][nx]){
                    queue.add(new int[] {nx, ny});
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
