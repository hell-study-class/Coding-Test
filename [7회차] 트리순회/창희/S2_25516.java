package baeckjoon.weeks4.thursday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_25516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] level = new int[100001];
        int[] apple = new int[100001];
        level[0] = 0;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            level[v] = level[p]+1;
        }
        apple = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for(int i=n-1; i>=0;i--){
            if(level[i] <= k){
                result += apple[i];
            }
        }
        System.out.println(result);
    }
}
