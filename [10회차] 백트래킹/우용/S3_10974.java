import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] arr;
    public static boolean[] visit;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void recursive(int depth){
        if(depth == n){
            print();
            return;
        }
        // 순열 구하는 방법
        for(int i = 1 ; i < arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                list.add(arr[i]);
                recursive(depth+1);
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }
    }

    private static void print() {
        for(int i = 0 ;i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visit = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = i;
        }
        recursive(0);
    }
}