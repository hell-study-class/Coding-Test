import java.util.*;

public class Main{
    public static int n ;
    public static int m ;
    public static int[] dx= {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};
    public static int[][] graph ;
    public static int[][] visited;
    public static int count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0 ;i<t; i++){
            count = 0;
            n = sc.nextInt();
            m = sc.nextInt();
            int k = sc.nextInt();

            graph = new int[n][m];
            visited = new int[n][m];

            for(int j = 0;j<k; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[x][y] = 1;
            }

            for(int p = 0; p<n;p++){
                for(int q = 0; q<m; q++){
                    if(visited[p][q] == 0 && graph[p][q] == 1){
                        dfs(p,q);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void dfs(int r, int c){
        visited[r][c] = 1;

        for(int i = 0 ; i<4; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];

            if(nr >=0 && nr <n && nc>=0 && nc<m){
                if(visited[nr][nc] == 0 && graph[nr][nc]==1){
                    dfs(nr,nc);
                }
            }
        }

    }
}