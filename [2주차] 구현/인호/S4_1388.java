import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static String[][] floor;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        floor = new String[y][x];

        for(int i =0; i<y; i++){
            String input = br.readLine();
            String[] inputArr = input.split("");
            for(int j =0; j<x; j++){
                floor[i][j] = inputArr[j];
            }
        }

        int xCount = 0;
        int yCount = 0;
        String ptr = "";
        for(int i=0;i<y;i++){
            for(int j=0; j<x; j++){
                xCount += xCountCal(i,j);
                yCount += yCountCal(i,j);
            }
        }

        bw.write(xCount+yCount+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int xCountCal(int y, int x){
        if(floor[y][x].equals("-")){
            if(x == 0){
                return 1;
            }else{
                if(floor[y][x-1].equals(floor[y][x])){
                    return 0;
                }else{
                    return 1;
                }
            }
        }
        return 0;

    }

    public static int yCountCal(int y, int x){
        if(floor[y][x].equals("|")){
            if(y == 0){
                return 1;
            }else{
                if(floor[y-1][x].equals(floor[y][x])){
                    return 0;
                }else{
                    return 1;
                }
            }
        }
        return 0;
    }
}