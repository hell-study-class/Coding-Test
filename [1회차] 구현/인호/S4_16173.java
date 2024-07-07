import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0}, dy = {0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        move(0,0);

        System.out.println("Hing");
    }

    public static void move(int i, int j){
        if(arr[i][j] == -1){
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for(int k =0; k<2; k++){
            int x = i + dx[k] * arr[i][j];
            int y = j + dy[k] * arr[i][j];

            if(x>=N||y>=N||visited[x][y]) continue;

            visited[x][y] = true;
            move(x,y);
        }
    }
}