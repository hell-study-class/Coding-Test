import java.util.*;

public class Main{
    public static int n ;
    public static int m ;
    public static int v ;
    public static int[] visited;
    public static int[][] graph ;
    public static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        graph = new int[n+1][n+1];
        visited = new int[n+1];

        for(int i = 0; i< m ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        dfs(v);
        System.out.println();
        visited = new int[n+1];
        bfs(v);
    }
    public static void bfs(int vertax){
        if(vertax == v){
            visited[v] = 1;
            que.add(vertax);
            System.out.print(vertax + " ");
        }
        while(!que.isEmpty()){
            int currV = que.poll();
            for(int i = 1; i<=n ; i++){
                if(visited[i]==0 && graph[currV][i] == 1){
                    System.out.print(i+" ");
                    visited[i] = 1;
                    que.add(i);
                }
            }
        }
    }

    public static void dfs(int vertax){
        if(vertax == v){
            visited[v] = 1;
            System.out.print(vertax + " ");
        }
        for(int i = 1; i<=n; i++){
            if(visited[i] == 0 && graph[vertax][i]==1){
                System.out.print(i+" ");
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}