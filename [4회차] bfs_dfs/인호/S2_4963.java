import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static int n,m,cnt;
    static int[] dx = {0,0,1,-1,1,-1,1,-1};
    static int[] dy = {1,-1,0,0,1,1,-1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m ==0){
                break;
            }
            map = new int[m][n];

            for(int i = 0; i < m; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st1.nextToken());
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == 1){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int y, int x){
        map[y][x] = 0;
        for(int i = 0; i < 8; i++){
            int cy = y + dy[i];
            int cx = x + dx[i];

            if(cy < m && cx <n && cy>=0 && cx>=0 ){
                if(map[cy][cx] == 1){
                    dfs(cy,cx);
                }
            }
        }
    }
}