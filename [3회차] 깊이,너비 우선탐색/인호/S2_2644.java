import java.io.*;
import java.util.*;

public class Main{
    static int n,a,b,m;
    static List<Integer>[] relation;
    static boolean[] check;
    static int res = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine())+1;
        relation = new ArrayList[n];
        check = new boolean[n];
        for(int i = 1; i < n; i++){
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());

            relation[x].add(y);
            relation[y].add(x);
        }

        dfs(a,b,0);

        System.out.println(res);
        br.close();
    }

    static void dfs(int start, int end, int cnt){
        if(start == end){
            res = cnt;
            return;
        }

        check[start] = true;
        for(int i = 0; i < relation[start].size(); i++){
            int next = relation[start].get(i);
            if(!check[next]){
                dfs(next,end,cnt+1);
            }
        }
    }
}