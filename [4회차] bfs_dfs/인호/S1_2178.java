import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main{
    static int[][] map;
    static boolean[][] visit;
    static int n,m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }



        bfs(0,0);

        System.out.println(map[n-1][m-1]);

        br.close();
    }

    static void bfs(int x, int y){
        visit[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            for(int i =0; i<4; i++){
                int cy = currentPoint.y + dy[i];
                int cx = currentPoint.x + dx[i];

                if(cy <0 || cy >= m || cx <0 || cx >=n){
                    continue;
                }

                if(map[cx][cy] == 0){
                    continue;
                }

                if(visit[cx][cy]){
                    continue;
                }

                queue.offer(new Point(cx,cy));
                visit[cx][cy] = true;
                map[cx][cy] = map[currentPoint.x][currentPoint.y] +1;
            }
        }
    }
}