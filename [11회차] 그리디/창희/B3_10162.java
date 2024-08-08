package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B3_10162 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = 300;
        int b = 60;
        int c = 10;

        if(t%10 > 0){
            System.out.println(-1);
            return;
        }
        int[] result = new int[3];
        while(t >= 10){
            if(t >= a){
                result[0] += t/a;
                t %= a;
            }else if(t >= b){
                result[1] += t/b;
                t %= b;
            }else if(t >= c){
                result[2] += t/c;
                t %= c;
            }
        }
        if(t > 0) {
            System.out.println(-1);
        }else{
            for(int i : result){
                System.out.print(i + " ");
            }
        }
        return;
    }
}
