package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class S1_25601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        StringTokenizer st;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            String p = st.nextToken();
            map.computeIfAbsent(p, key-> new ArrayList<>()).add(c);;
        }
        st = new StringTokenizer(br.readLine());
        String c = st.nextToken();
        String p = st.nextToken();

        Queue<String> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(c);
        while(!queue.isEmpty()){
            String temp = queue.poll();
            if(map.get(temp) != null){
                for(String t : map.get(temp)){
                    if(t.equals(c) || t.equals(p)){
                        System.out.println(1);
                        return;
                    }
                    queue.offer(t);
                }
            }
        }
        System.out.println(0);
    }
    public static void dfs(String parent, String child, HashMap<String, String> map){

    }
}
