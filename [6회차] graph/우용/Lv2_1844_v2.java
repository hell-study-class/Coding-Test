import java.util.*;

class Solution {
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public int solution(int[][] maps) {

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);

        return visited[maps.length-1][maps[0].length-1] == 0 ? -1 : visited[maps.length-1][maps[0].length-1];
    }

    public static void bfs(int[][] m, int[][] v){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});    // 0,0 을 넣는다.
        v[0][0] = 1;            // 시작 위치 방문 체크

        while(!q.isEmpty()){    // 큐에 데이터가 존재한다면
            int[] q_poll = q.poll();
            int x = q_poll[0];  // x 좌표 값 추출
            int y = q_poll[1];  // y 좌표 값 추출

            for(int i = 0;i<4; i++){
                int nx = x+dx[i];   // 이동할 x 좌표
                int ny = y+dy[i];   // 이동할 y 좌표

                if(nx < 0 || ny < 0 || nx > m.length-1 || ny > m[0].length-1){
                    continue;
                }

                if(v[nx][ny] == 0 && m[nx][ny] == 1){   // 방문 하지 않았고, 벽이 아닐 경우
                    v[nx][ny] = v[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}
