import java.io.*;
import java.util.*;

public class Main {
    static int[][][] box;
    static int n, m, h;
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][m][n];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    box[i][j][k] = Integer.parseInt(st1.nextToken());
                }
            }
        }

        int days = bfs();
        System.out.println(days);
        br.close();
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int days = -1;


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int z = point[0];
                int y = point[1];
                int x = point[2];

                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (nz >= 0 && nz < h && ny >= 0 && ny < m && nx >= 0 && nx < n && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        queue.add(new int[]{nz, ny, nx});
                    }
                }
            }
        }


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days;
    }
}
