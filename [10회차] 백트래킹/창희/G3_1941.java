package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G3_1941 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] field = new char[5][5];
    static int result = 0;
    static boolean[][] visited2 = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            field[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[5][5];

        for(int i=0; i<25; i++){
            visited[i/5][i%5] = true;
            bfs(i/5, i%5, 0, 0, 0, visited);
            visited[i/5][i%5] = false;
        }
        System.out.println(result);
    }
    public static void bfs(int x, int y, int depth, int count_s, int count_y, boolean[][] visited){

        if(depth == 0){
            if(field[y][x] == 'S'){
                count_s++;
            }else{
                count_y++;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[ny][nx]) {
                    continue;
                }

                if (field[ny][nx] == 'S') {
                    count_s++;
                } else {
                    count_y++;
                }
                if (count_y > 3) {
                    continue;
                }
                visited[ny][nx] = true;
                queue.add(new int[]{nx, ny});
                depth++;
                System.out.print("depth : "+ depth + " ");
//            bfs(nx, ny, depth+1, count_s, count_y, visited);
//            if(field[ny][nx] == 'S'){
//                count_s--;
//            }else{
//                count_y--;
//            }
//            visited[ny][nx] = false;
            }
            if(depth == 6){
                if(count_s >= 4){
                    System.out.println(x + " " + y );
                    result++;
                }
            }
        }
    }
}
