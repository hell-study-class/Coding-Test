import java.io.*;
import java.util.*;

public class Main{
    static int T,M,N,K;
    static boolean[][] visit;
    static int[][] cabage;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while(T > 0){
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabage = new int[N][M];
            visit = new boolean[N][M];

            for(int i = 0; i < K; i++){
                StringTokenizer xy = new StringTokenizer(br.readLine());

                int px = Integer.parseInt(xy.nextToken());
                int py = Integer.parseInt(xy.nextToken());

                cabage[py][px] = 1;
            }

            for(int y = 0; y < N; y++){
                for(int x = 0; x < M; x++){
                    if(cabage[y][x] == 1 && !visit[y][x]){
                        dfs(x,y);
                        count++;
                    }
                }
            }

            bw.write(count+"");
            bw.newLine();
            T--;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y){
        visit[y][x] = true;

        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < M && cy < N){
                if(!visit[cy][cx] && cabage[cy][cx] == 1){
                    dfs(cx,cy);
                }
            }
        }
    }
}