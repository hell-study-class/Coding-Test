package baeckjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        char[] ch = temp.toCharArray();
        boolean check = false;
        String[] arr = new String[ch.length];
        int index = 0;
        for(int i=0; i<ch.length; i++) {

            if(ch[i] == '<'){
                index++;
                check = true;
            }else if(ch[i] == '>'){
                check = false;
                arr[index] += ch[i];
                index++;
                continue;
            }else if(ch[i] == ' ' && !check){
                index++;
                arr[index++] += ' ';
                continue;
            }
            arr[index] += ch[i];
        }


        for(int i=0; i<arr.length; i++){
            if(arr[i] == null){
                System.out.print("");
                continue;
            }else if(arr[i].charAt(4) == '<'){
                System.out.print(arr[i].substring(4,arr[i].length()));
                continue;
            }
            for(int j= arr[i].length()-1; j>=4; j--){
                System.out.print(arr[i].charAt(j));
            }
        }
    }
}
