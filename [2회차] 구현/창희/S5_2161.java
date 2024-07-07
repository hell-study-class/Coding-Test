package baeckjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S5_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> arrayList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
            arrayList.add(i+1);
        }

        for(int i = 0; i < n-1; i++) {
            sb.append(arrayList.remove(0)).append(" ");
            int temp = arrayList.remove(0);
            arrayList.add(temp);
        }
        sb.append(arrayList.remove(0));
        System.out.println(sb);

    }
}
