import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(a);

        while(true){
            int new_num = nextNum(a,p);

            if(list.contains(new_num)){
                System.out.println(list.indexOf(new_num));
                return;
            }
            list.add(new_num);
            a = new_num;

        }

    }

    // 각 자리의 자를 P 제곱한 수들의 합
    public static int nextNum(int a, int p){
        int num = 0;
        while( a != 0){
            num += Math.pow(a % 10,(double) p);
            a /= 10;
        }
        return num;
    }
}