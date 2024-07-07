package baeckjoon.weeks2.thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class S2_2644 {
    public static int[][] family_map;
    public static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        family_map = new int[n][n];
        check = new boolean[n];
        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            family_map[p-1][c-1] = 1;
            family_map[c-1][p-1] = 1;
        }
        System.out.println(bfs(p1-1, p2-1));;
    }
    public static int bfs(int p1, int p2){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p1);
        check[p1] = true;

        while(!queue.isEmpty()){
            int q = queue.poll();

            for(int i=0; i < family_map.length; i++){
                if(family_map[q][i] > 0 && !check[i]){
                    check[i] = true;
                    queue.add(i);
                    family_map[p1][i] = family_map[p1][q] + family_map[q][i];
                    if(i == p2){
                        return family_map[p1][i];
                    }
                }

            }
        }
        return -1;
    }
}
