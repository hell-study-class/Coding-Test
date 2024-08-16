import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long rs = 0 ;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] setPrices = new int[m];
        int[] unitPrices = new int[m];

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            setPrices[i] = Integer.parseInt(st.nextToken());
            unitPrices[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(setPrices);
        Arrays.sort(unitPrices);

        int setCnt = n/6 ;
        int unitCnt = n%6;

        if(n < 6){
            if(setPrices[0] > unitPrices[0] * n){
                rs += unitPrices[0] *n;
            }else{
                rs += setPrices[0];
            }
        }else{
            if(setPrices[0] > unitPrices[0] * 6){
                rs += unitPrices[0] * (setCnt*6);
            }else{
                rs += setPrices[0] * setCnt;
            }

            if(unitCnt != 0){
                if(setPrices[0] > unitCnt * unitPrices[0]){
                    rs += unitCnt * unitPrices[0];
                }else{
                    rs += setPrices[0];
                }
            }
        }
        System.out.println(rs);
    }
}