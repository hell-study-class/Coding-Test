package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_14889 {
    static int n;
    static int[][] table;
    static int[] result;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        result = new int[n];
        for(int i=0; i<n; i++){
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] team1 = new int[n/2];
        int[] team2 = new int[n/2];
        team1[n/2-1] = -1;
        boolean[] visited = new boolean[n];

        backtrack(team1, team2, 0, visited, 0);
        System.out.println(min);
    }
    public static void backtrack(int[] team1, int[] team2, int depth, boolean[] visited, int s){
        if(depth == n/2){
            int k=0;
            for(int i=0; i<n ; i++){
                if(visited[i]) continue;
                team2[k++] = i;
            }
            min = Math.min(Math.abs(calculate(team1) - calculate(team2)), min);
            return;
        }
        for(int i=s; i<n; i++){
            if(depth < n/2 && !visited[i]){
                team1[depth] = i;
                visited[i] = true;
                backtrack(team1, team2, depth+1, visited, i+1);
                team1[depth] = -1;
                visited[i] = false;
            }


        }
    }
    public static int calculate(int[] team){
        int sum = 0;
        for(int i=0; i<n/2; i++){
            for(int j=i+1; j<n/2; j++){
                if(i == j) continue;
                sum += table[team[i]][team[j]] + table[team[j]][team[i]];
            }
        }
        return sum;
    }
}
