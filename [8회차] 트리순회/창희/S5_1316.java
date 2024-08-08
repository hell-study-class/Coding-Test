package day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S5_1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<n; i++){
            String str = br.readLine();
            result += isGroupWord(str);
        }
        System.out.println(result);
    }
    public static int isGroupWord(String str){
        char[] arr = str.toCharArray();
        int[] check = new int[26];
        char temp = arr[0];
        check[arr[0]-'a'] = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == temp) continue;
            if(arr[i] != temp && check[arr[i] - 'a'] == 0){
                temp = arr[i];
                check[arr[i] - 'a'] = 1;
            }
            if(arr[i] != temp && check[arr[i]-'a'] > 0){
                return 0;
            }
        }
        return 1;
    }
}
