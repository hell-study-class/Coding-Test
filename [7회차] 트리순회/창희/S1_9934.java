package baeckjoon.weeks4.thursday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class S1_9934 {
        static int k;
        static ArrayList<Integer>[] tree;
        static int[] buildings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        tree = new ArrayList[k+1];
        buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        search(0, 0, buildings.length);
        for(int i = 0; i<tree.length; i++){
            if(tree[i] == null){
                continue;
            }
            for(int j =0; j < tree[i].size(); j++){
                System.out.print(tree[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    static void search(int depth, int start, int end){

        int mid = (start + end)/2;
        if(tree[depth] == null){
            tree[depth] = new ArrayList<>();
        }
        if(depth == k)
            return;
        tree[depth].add(buildings[mid]);

        search(depth+1, start, mid-1);
        search(depth+1, mid+1, end);
    }
}
