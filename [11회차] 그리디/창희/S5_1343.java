package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] temp = line.split("\\.");

        for(int i=0; i<temp.length; i++){
            int t = temp[i].length();
            if(t % 2 != 0){
                System.out.println(-1);
                return;
            }
            StringBuilder sb = new StringBuilder();
            while(t > 0) {
                if(t >= 4){
                    int count = t/4;
                    for(int j=0; j<count; j++){
                        sb.append("AAAA");
                    }
                    t %= 4;
                }
                if(t >= 2){
                    int count = t/2;
                    for(int j=0; j<count; j++){
                        sb.append("BB");
                    }
                    t %= 2;
                }
                temp[i] = sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if(temp.length <= 0){

            System.out.println(line);
            return ;
        }
        sb2.append(temp[0]);
        int count = temp[0].length();
        for(int i=1; i<temp.length; i++){
            count += temp[i].length();
            if(!temp[i].equals(".")){
                sb2.append(".");
                sb2.append(temp[i]);
            }else{
                count++;
                sb2.append(temp[i]);
            }
        }
//        if(count != line.length()){
//            for(int i=0; i<line.length()-count; i++){
//                sb2.append(".");
//            }
//        }
        for(int i=line.length()-1; i>=0; i--){
            if(line.charAt(i) == '.'){
                sb2.append('.');
            }else{
                break;
            }
        }
        System.out.println(sb2);

    }
}
