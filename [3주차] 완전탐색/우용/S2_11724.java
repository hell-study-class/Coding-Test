import java.util.*;

public class Main{
    public static int n ;
    public static int m;
    public static int[][] graph;
    public static int[] visited;
    public static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n+1][n+1];
        visited = new int[n+1];

        for(int i = 0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        for(int i = 1; i<=n;i++){
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            dfs(i);
            count++;
        }
        System.out.println(count);
    }

    public static void dfs(int vertax){
        for(int i = 1 ; i<=n; i++){
            if(visited[i] == 0 && graph[vertax][i]==1){
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}