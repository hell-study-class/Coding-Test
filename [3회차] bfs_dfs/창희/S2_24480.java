package baeckjoon.weeks2.thursday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2_24480 {
    public static ArrayList<ArrayList<Integer>> map;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        visited = new boolean[n];

        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.get(x-1).add(y-1);
            map.get(y-1).add(x-1);
        }

        for(int i=0; i<n; i++){
            if(map.get(i).size() > 0)
            Collections.sort(map.get(i));
        }
        dfs(n, r-1);

    }
    public static void dfs(int n, int r){
        Stack<Integer> stack = new Stack<>();
        stack.push(r);
        visited[r] = true;
        int[] result = new int[n];
//        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while(!stack.isEmpty()){
            int x = stack.pop();
            result[x] = ++index;
            for(int i=0; i<map.get(x).size(); i++){
                if(!visited[map.get(x).get(i)]){
                    visited[map.get(x).get(i)] = true;
                    stack.push(map.get(x).get(i));
                }
            }
        }
        for(int i:result){
            System.out.println(i);
        }
    }
}
