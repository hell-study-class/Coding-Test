package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = m-n;
            int k = n;
            long x=1, y = 1;
            if(d < n){
                k = d;
            }
            for(int j=1; j<=k;j++){
                y *= j;
                x *= (m-j + 1);
            }
            System.out.println(x/y);
        }
    }
}
