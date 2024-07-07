package baeckjoon.weeks2.thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {
    public static int[][] map;
    public static boolean[][] check;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n;
    public static int m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<arr.length; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        check[0][0] = true;
        while(!queue.isEmpty()){
            int[] location = queue.poll();
            int x = location[0];
            int y = location[1];
            for(int i=0; i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                    continue;
                }
                if(map[ny][nx] > 0 && !check[ny][nx]){
                    map[ny][nx] = map[y][x] + 1;
                    check[ny][nx] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        if(map[map.length-1][map[0].length-1] > 0){
            return map[map.length-1][map[0].length-1];
        }else{
            return -1;
        }
    }
}
