import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] arr;
    public static boolean[] visit;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int max = 0;
    private static int calc() {
        int sum = 0;
        for(int i = 2; i<list.size()+1; i++){
            sum += Math.abs(list.get(i-2) - list.get(i-1));
        }
        return sum;
    }

    public static void recursive(){
        if(list.size() == arr.length){
            max = Math.max(max, calc());
            return;
        }
        for(int i = 0 ; i<arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                list.add(arr[i]);
                recursive();
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recursive();
        System.out.println(max);
    }
}