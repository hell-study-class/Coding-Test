import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for(int i = 0; i<2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<n; j++){
                if(i==0){
                    a[j] = Integer.parseInt(st.nextToken());
                }else{
                    b[j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        int sum = 0;
        for(int i = 0 ; i <n; i++){
            sum += a[i] * b[i];

        }
        System.out.println(sum);
    }
}