package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_14244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int leafCount = 0;
        if(m == 2){
            leafCount = 1;
        }

        int lastLeafIdx = 0;
        for(int i=1; i<n; i++){
            if(m > leafCount){
                leafCount += 1;
                System.out.println(0 + " " + i);
            }else{
                System.out.println(lastLeafIdx + " " + i);
            }
            lastLeafIdx = i;
        }
    }
}
