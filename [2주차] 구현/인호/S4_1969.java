import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static String[] dna;
    static int hd;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result =new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        dna = new String[n];

        for(int i = 0; i < n; i++){
            dna[i] = br.readLine();
        }


        for(int i = 0; i < m; i++){
            int[] dist = new int[4];
            for(int j=0;j<n; j++){
                char d = dna[j].charAt(i);
                switch(d){
                    case 'A':
                        dist[0]++;
                        break;
                    case 'C':
                        dist[1]++;
                        break;
                    case 'G':
                        dist[2]++;
                        break;
                    case 'T':
                        dist[3]++;
                        break;
                }
            }

            int max = 0;
            int idx = 0;
            for(int k=0; k<4; k++){
                if(dist[k] > max || (dist[k] == max && k < idx)){
                    max = dist[k];
                    idx = k;
                }
            }
            switch(idx){
                case 0:
                    result.append('A');
                    break;
                case 1:
                    result.append('C');
                    break;
                case 2:
                    result.append('G');
                    break;
                case 3:
                    result.append('T');
                    break;
            }
            hd += n - max;
        }

        System.out.println(result.toString());
        System.out.println(hd);
        br.close();
    }
}