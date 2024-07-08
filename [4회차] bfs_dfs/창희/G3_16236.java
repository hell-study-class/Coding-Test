package baeckjoon.weeks3.monday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_16236 {
    public static int[][] field;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        //처음에 아기 상어 크기는 2, 자신보다 큰 물고기가 있는 칸은 못지나감
//        크기가 작거나 같은 물고기는 지나갈 수 있음, 자기보다 작아야 먹을 수 있음
        // 더이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어를 부름
        //먹을 수 있는 물고기가 1마리면 그 물고기 먹고, 여러 마리면 가장 가까운 물고기를 먹는다.
            // 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        field = new int[n][n];
        visited = new boolean[n][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] == 9){
                    x = j;
                    y = i;
                    field[i][j] = 0;
                }
            }
        }
        int level = 2;
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){

            }
        }
        bfs(x, y);
    }
    public static void bfs(int x, int y) {
        int sec = 0;   // 엄마 상어를 부르기 까지의 시간
        int level = 2; // level을 붙여서 먹을 수 있는 물고기를 판별
        int count = 0; // 몇 마리의 물고기를 먹었는지 levelup을 위한 count
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx > field.length-1 || ny < 0 || ny > field.length-1) continue;

                if(field[ny][nx] < level && field[ny][nx] > 0){
                    q.add(new int[] {nx, ny});
                    count++;
                    if(count == level){
                        level++;
                        count = 0;
                    }
                    sec++;
                    visited[ny][nx] = true;
                    field[ny][nx] = 0;
                }else if(field[ny][nx] == level || field[ny][nx] == 0){
                    q.add(new int[] {nx, ny});
                    sec++;
                }

            }
        }
        System.out.println(sec);
    }
}
