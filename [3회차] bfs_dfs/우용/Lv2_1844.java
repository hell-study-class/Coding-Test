import java.util.*;

class Solution {
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }
    public static void bfs(int[][] maps, int[][] visited){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0});

        visited[0][0] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length){
                    continue;
                }
                if(visited[nx][ny] == 0 && maps[nx][ny] == 1){
                    visited[nx][ny] = visited[cx][cy]+1;
                    q.add(new int[]{nx,ny});
                }
            }

        }
    }
}