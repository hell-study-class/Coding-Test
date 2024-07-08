package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Josephus_zero_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i < n; i++) {
            arr.add(i+1);
        }
        result.append('<');

        int index = 0;

        for(int i=0; i<n-1; i++) {
            index =(index + (k-1)) % arr.size();
            result.append(arr.remove(index)).append(", ");
        }
        result.append(arr.get(0)).append(">");

        System.out.println(result);
    }
}
