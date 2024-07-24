import java.util.Scanner;

public class Main{
    public static int[][] graph;
    public static int[][] visited;
    public static int n;
    public static int p1;
    public static int p2;
    public static int m;
    public static int rs = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        visited = new int[n+1][n+1];

        for(int i = 0; i<m; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph[parent][child] = 1;
            graph[child][parent] = 1;
        }

        dfs(p1,0);

        if(rs == 0){
            System.out.println(-1);
        }else{
            System.out.println(rs);
        }
    }

    public static void dfs(int v, int count){
        if(v == p2){
            rs = count;
            return;
        }
        for(int i = 1 ; i<=n; i++){
            if(graph[v][i] == 1 && visited[v][i] == 0){
                visited[v][i] =1 ;
                visited[i][v] =1;
                count++;
                dfs(i, count);
                count--;
            }
        }

    }
}