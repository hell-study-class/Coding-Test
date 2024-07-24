package baeckjoon.weeks3.monday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G5_10026 {
    public static String[][] field;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        field = new String[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            field[i] = br.readLine().split("");
        }
        int result1 = 0;
        int result2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == false){
                    result1 += bfs(j, i);
                }
            }
        }
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == false){
                    result2 += bfs2(j, i);
                }
            }
        }
        System.out.println(result1 + " " + result2);

    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{x, y});
        String color = field[y][x];
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx > field.length-1 || ny < 0 || ny > field.length-1 || visited[ny][nx]) continue;

                if(field[ny][nx].equals(color)){
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return 1;
    }

    public static int bfs2(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{x, y});
        String color = field[y][x];
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx > field.length-1 || ny < 0 || ny > field.length-1 || visited[ny][nx]) continue;


                if((color.equals("R") || color.equals("G")) && (field[ny][nx].equals("R") || field[ny][nx].equals("G"))){
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny});
                }else if(field[ny][nx].equals("B") && color.equals("B")){
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return 1;
    }
}
