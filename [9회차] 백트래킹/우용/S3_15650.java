import java.util.*;
import java.io.*;

public class Main {
    public static int n,m;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        recursive(1, 0);
    }

    public static void recursive(int start, int depth){
        if(depth == m){
            for(int i = 0 ; i < list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            return ;
        }
        for(int i = start; i<=n;i++){
            if(!list.contains(i)){
                list.add(i);
                recursive(i+1, depth+1);
                list.remove(list.size()-1);
            }
        }
    }
}