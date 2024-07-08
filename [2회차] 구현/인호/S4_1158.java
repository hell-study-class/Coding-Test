import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> array = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for(int i =1; i<n+1; i++){
            array.add(i);
        }

        int index = 0;
        while(!array.isEmpty()){
            index = (index+k-1) % array.size();
            result.add(array.remove(index));
        }

        bw.write("<");
        for(int i=0; i<result.size(); i++){
            if(i == result.size()-1){
                bw.write(result.get(i)+"");
            }else{
                bw.write(result.get(i)+", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}