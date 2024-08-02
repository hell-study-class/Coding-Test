import java.util.*;
import java.io.*;

public class Main{
    public static int n,k;
    public static int[] kit;
    public static int[] visit;
    public static ArrayList<Integer> list = new ArrayList();
    public static int WEIGHT = 500;
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        kit = new int[n+1];
        visit = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0);

        System.out.println(count);
    }

    public static void recursive(int depth){
        if(depth == n){
            count++;
            return;
        }

        for(int i = 1 ; i <kit.length; i++ ){
            if(visit[i]== 0&& (WEIGHT + kit[i] - k) >= 500){
                visit[i] = 1;
                list.add(i);
                WEIGHT = WEIGHT - k + kit[i];
                recursive(depth+1);
                visit[i] = 0;
                WEIGHT = WEIGHT+k - kit[i];
                list.remove(list.size()-1);
            }
        }
    }
}