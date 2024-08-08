import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int k;
    public static boolean[] arr;
    public static boolean[] visit = new boolean[10];
    public static ArrayList<Integer> list = new ArrayList<>();
    public static long max = 0;
    public static String maxStr ="";
    public static long min = 9999999999L;
    public static String minStr ="";
    public static void recursive(int depth){
        if(depth == k+1){
            if(possible()){
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < list.size(); i++){
                    sb.append(list.get(i));
                }
                long num = Long.parseLong(sb.toString());
                if(Math.max(max, num)==num){
                    max = num;
                    maxStr = sb.toString();
                };
                if(Math.min(min, num)==num){
                    min = num;
                    minStr = sb.toString();
                };
            }
            return;
        }

        for(int i = 0 ; i < 10; i++){
            if(!visit[i]){
                visit[i]= true;
                list.add(i);
                recursive(depth+1);
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }
    }

    private static boolean possible() {
        for(int i = 0 ; i<arr.length; i++){
            if(arr[i]){
                if(list.get(i) >= list.get(i+1)){
                    return false;
                }
            }else{
                if(list.get(i) <= list.get(i+1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        String[] signs = br.readLine().split(" ");

        arr = new boolean[k];

        for(int i = 0 ; i < k; i++){
            if(signs[i].equals("<")) arr[i] = true;
            else arr[i] = false;
        }

        recursive(0);

        System.out.println(maxStr);
        System.out.println(minStr);
    }
}