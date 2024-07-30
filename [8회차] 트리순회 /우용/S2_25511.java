import java.util.*;

public class Main{
    public static int n;
    public static int k;
    public static ArrayList<Integer>[] list;
    public static boolean[] visit;
    public static int[] values;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        list = new ArrayList[n];
        visit = new boolean[n];
        values = new int[n];

        for(int i = 0 ; i<n ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            list[parent].add(child);
        }

        for(int i = 0 ; i < n ; i++){
            values[i] = sc.nextInt();
        }

        dfs(0,0);
    }

    public static void dfs(int s, int d){
        visit[s] = true;            // 방문 기록 체크

        if(values[s] == k){         // 현재 위치의 값이 k와 일치한다면 현재 depth 출력
            System.out.println(d);
            return;
        }

        for(int i : list[s]){
            if(!visit[i]){          // 방문을 하지 않았을 경우
                dfs(i,d+1);
            }
        }
    }
}