import java.util.*;

public class Main{
    public static int n;
    public static int[] parent;
    public static boolean[] visit;
    public static ArrayList<Integer> list[] ;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visit = new boolean[n+1];
        list = new ArrayList[n+1];
        parent = new int[n+1];

        for(int i = 0 ; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i = 2 ; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int index){
        visit[index] = true;
        for(int i : list[index]){
            if(!visit[i]){
                parent[i] = index;
                dfs(i);
            }
        }
    }
}