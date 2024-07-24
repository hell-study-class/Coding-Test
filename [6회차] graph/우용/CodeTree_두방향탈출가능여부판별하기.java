import java.util.*;

public class Main {

    public static int n ;
    public static int m;
    public static int[][] graph;
    public static int[][] visited;
    public static int[] dx = new int[]{1,0};
    public static int[] dy = new int[]{0,1};
    public static boolean status ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][m+1];
        visited = new int[n+1][m+1];

        for(int i = 1 ; i<=n; i++){
            for(int j = 1; j<=m; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        dfs(1,1);

        if(status){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static void dfs(int r, int c){
        if(r == n && c==m){
            status = true;
            return;
        }
        for(int i = 0 ; i<2; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nc < 0 || nr >n|| nc >m){
                continue;
            }

            if(graph[nr][nc] == 1 & visited[nr][nc] == 0){
                visited[nr][nc] = 1;
                dfs(nr,nc);
            }
        }
    }
}