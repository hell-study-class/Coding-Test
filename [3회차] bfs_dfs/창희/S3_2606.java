package baeckjoon.weeks2.thursday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_2606 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int computer;
    static boolean[] check;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());

        map = new int[computer][computer];
        check = new boolean[computer];
        count = 0;
        check[0] = true;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
            map[b-1][a-1] = 1;
        }

        bfs(0);
        System.out.println(count);
    }
    public static void bfs(int a) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()) {
            int j = q.poll();
            for(int i=0; i<computer; i++){
                if(map[i][j] == 1 && !check[i]){
                    q.add(i);
                    check[i] = true;
                    count++;
                }
            }
        }
    }
}
