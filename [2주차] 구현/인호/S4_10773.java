import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        int n;
        ArrayList<Integer> list = new ArrayList<>();
        int index=-1;
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        while(n>0){
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                list.remove(index);
                index--;
            }else{
                list.add(input);
                index++;
            }
            n--;
        }


        for(int num : list){
            result+=num;
        }


        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
    }
}