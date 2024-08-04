package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_1759 {
    static int l, c;
    static char[] arr;
    static char[] field = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        backtrack(new StringBuilder(), 0, 0, new boolean[c], 0, 0);
    }
    public static void backtrack(StringBuilder sb, int depth, int start, boolean[] visited, int gather, int consonant){
        if(depth == l){
            if(gather >= 1 && (l-gather) >= 2){
                System.out.println(sb);
            }
            return;
        }

        for(int i=start; i<c; i++){
            if(!visited[i]){
                sb.append(arr[i]);
                visited[i] = true;
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                    gather++;
                }
                backtrack(sb, depth+1, i+1, visited, gather, consonant);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                    gather--;
                }
            }
        }
    }
}
