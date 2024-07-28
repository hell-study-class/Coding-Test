import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int n ;
    public static int[][] graph;
    public static int[][] visited;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};
    public static int count = 0;
    public static int sum = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n+1][n+1];
        visited = new int[n+1][n+1];

        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=n; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            for(int j =1; j<=n; j++){
                if(visited[i][j] == 0 && graph[i][j] == 1){
                    sum = 0;
                    dfs(i,j);
                    if(sum == 0){
                        sum = 1;
                    }
                    list.add(sum);
                    count++;
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int i = 0;i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int r, int c){

        for(int i = 0; i<4; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];

            if(nr<1 || nc<1 || nr >n || nc >n){
                continue;
            }

            if(visited[nr][nc] == 0 && graph[nr][nc] == 1){
                sum++;
                visited[nr][nc] = 1;
                dfs(nr,nc);
            }

        }

    }
}