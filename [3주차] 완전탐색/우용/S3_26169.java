import java.util.*;

public class Main{

    public static int n = 5;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static boolean status;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int apple = 0;
        int[][] graph = new int[5][5];
        for(int i = 0 ; i<n; i++){
            for(int j = 0 ;j<n;j++){
                graph[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();

        dfs(r,c, count, apple, graph);

        if(status){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    public static void dfs(int r, int c,int count, int apple, int[][] graph){
        graph[r][c] = -1;
        if(apple >=2){
            status = true;
            return;
        }
        if(count >= 3) {
            return;
        }



        for(int i = 0; i<4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nr > n-1 || nc < 0 || nc > n-1){
                continue;
            }
            if(graph[nr][nc] == -1){
                continue;
            }

            if (graph[nr][nc] == 1) {
                dfs(nr,nc, count+1, apple+1,graph);
                graph[nr][nc] = 1;
            }else if (graph[nr][nc] == 0) {
                dfs(nr,nc, count+1, apple,graph);
                graph[nr][nc] = 0;
            }
        }
    }
}