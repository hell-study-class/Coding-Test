package baeckjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        int size = 0;
        String result = "";
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            if(temp.length() > 9){
                String[] command = temp.split(" ");
                if(command[0].equals("push_front")){
                    for(int j=0; j<size; j++){
                        arr[j+1] = arr[j];
                    }
                    arr[0] = Integer.parseInt(command[1]);
                    size++;
                }else if(command[0].equals("push_back")){
                    arr[size%10000] = Integer.parseInt(command[1]);
                    size++;
                }
            }else {
                if(temp.equals("pop_front")){
                    if(size == 0){
                        result += "-1\n";
//                        System.out.println(-1);
                    }else{
                        result += arr[0]+"\n";
//                        System.out.println(arr[0]);
                        for(int j=0; j<size-1; j++){
                            arr[j] = arr[j+1];
                        }
                        size--;
                    }
                }else if(temp.equals("pop_back")){
                    if(size <= 0){
                        result += "-1\n";
//                        System.out.println(-1);
                    }else{
                        result += arr[size-1] + "\n";
//                        System.out.println(arr[size-1]);
                        arr[size-1] = 0;
                        size--;
                    }
                }else if(temp.equals("size")){
                    result += size + "\n";
//                    System.out.println(size);
                } else if (temp.equals("empty")) {
                    if(size>0){
                        result += "0\n";
//                        System.out.println(0);
                    }else {
                        result += "1\n";
//                        System.out.println(1);
                    }
                } else if (temp.equals("front")) {
                    if(size <= 0){
                        result += "-1\n";
//                        System.out.println(-1);
                    }else{
                        result += arr[0]+"\n";
//                        System.out.println(arr[0]);
                    }

                } else if (temp.equals("back")) {
                    if(size <= 0){
                        result += "-1\n";
//                        System.out.println(-1);
                    }else{
                        result +=  arr[size-1]+ "\n";
//                        System.out.println(arr[size-1]);
                    }

                }
            }
        }
        System.out.println(result.substring(0, result.length()-1));

    }
}
