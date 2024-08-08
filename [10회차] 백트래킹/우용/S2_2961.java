import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] arr;
    public static ArrayList<Integer> selected;
    public static boolean[] visit ;
    public static long diff = 1_000_000_000L;

    // 조합 방식
    public static void combi(int start, int depth, int to){
        if(depth == to){
            int value = calc();
            diff = Math.min(diff,value);
            return;
        }
        for(int i = start; i < n; i++){
            selected.add(i);
            combi(i+1, depth+1,to);
            selected.remove(selected.size()-1);
        }
    }

    private static int calc() {
        long s = 1;
        int b = 0;
        for(int i = 0 ; i < selected.size() ; i++){
            s*=arr[selected.get(i)][0];
            b+=arr[selected.get(i)][1];
        }
        return (int)Math.abs(s-b);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        visit = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=n;i++){
            selected = new ArrayList<>();
            combi(0,0,i);
        }
        System.out.println(diff);
    }
}