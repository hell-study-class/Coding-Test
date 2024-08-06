import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static int n;
    public static int[][] graph;
    public static ArrayList<Integer> list= new ArrayList<>();
    public static int min = 200;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0,0);

        System.out.println(min);
    }

    public static int sum(List<Integer> nums){
        int sum = 0 ;
        for(int i = 0 ; i < nums.size()-1; i++){
            for(int j =i+1; j<nums.size(); j++){
                sum += graph[nums.get(i)][nums.get(j)] ;
                sum += graph[nums.get(j)][nums.get(i)];
            }
        }
        return sum;
    }

    public static void recursive(int start, int depth){
        if(depth == n/2){
            int startSum = sum(list);
            ArrayList<Integer> linkLisk = new ArrayList<>();
            for(int i = 0 ; i<n; i++){
                if(!list.contains(i)){
                    linkLisk.add(i);
                }
            }
            int linkSum = sum(linkLisk);
            int distance = Math.abs(startSum - linkSum);
            if(min > distance){
                min = distance;
            }
            return ;
        }

        for(int i = start; i< n; i++){
            list.add(i);
            recursive(i+1,depth+1);
            list.remove(list.size()-1);
        }
    }

}