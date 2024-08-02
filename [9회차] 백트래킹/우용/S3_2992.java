import java.util.*;
import java.io.*;

public class Main {
    public static int x;
    public static int size;
    public static ArrayList<Integer> arr  = new ArrayList<>();
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int min = 999999;
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splitArr = br.readLine().split("");
        x = Integer.parseInt(String.join("",splitArr));
        size = splitArr.length;

        for(int i = 0 ; i < size; i++){
            arr.add(Integer.parseInt(splitArr[i]));
        }

        recursive(new ArrayList<Integer>(),0);
        if(min == 999999){
            System.out.println(0);
        }else{
            System.out.println(min);
        }
    }

    public static void recursive(List<Integer> indexs, int depth){
        if(depth == size){
            int num = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< list.size(); i++){
                sb.append(list.get(i));
            }
            num = Integer.parseInt(sb.toString());
            if(num > x && num <= min){
                min = num;
            }
            return;
        }

        for(int i = 0 ; i < arr.size(); i++){
            if(!indexs.contains(i)){
                list.add(arr.get(i));
                indexs.add(i);
                recursive(indexs,depth+1);
                indexs.remove((Object) i);
                list.remove(list.size()-1);
            }
        }
    }
}