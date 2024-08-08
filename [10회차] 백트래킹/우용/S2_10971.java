import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] w;
    public static boolean[] visit;
    public static int min = 1000000000;
    public static ArrayList<Integer> list = new ArrayList<>();

    private static int calc() {
        int sum = 0;
        for(int i = 2; i < list.size()+1; i++){
            if(i == list.size()){
                sum+=w[list.get(i-1)][list.get(0)];
            }
            sum += (w[list.get(i-2)][list.get(i-1)]);
        }
        return sum;
    }

    public static void recursive(int depth){
        if(depth == n){
            if(possible()){
                int sum = calc();
                min = Math.min(min,sum);
            }
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                list.add(i);
                recursive(depth+1);
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }
    }

    private static boolean possible() {
        for(int i = 2; i < list.size()+1; i++){
            if(w[list.get(i-2)][list.get(i-1)]==0){
                return false;
            }
            if(w[list.get(list.size()-1)][list.get(0)] == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        visit = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0);
        System.out.println(min);
    }
}