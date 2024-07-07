package backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] n_word = word.toCharArray();
        int count = 0;
        for(int i=0; i<n_word.length; i++) {
            if(i < n_word.length-1) {
                continue;
            }
            if(n_word[i] == 'c'){
                if(i < n_word.length-1) {
                    if (n_word[i + 1] == '=' || n_word[i + 1] == '-') {
                        i++;
                    }
                }
            }else if(n_word[i] == 'd'){
                if(i < n_word.length-1) {
                    if (n_word[i + 1] == '-') {
                        i++;
                    } else if (n_word[i + 1] == 'z') {
                        if(i < n_word.length-2) {
                            if (n_word[i + 2] == '=') {
                                i += 2;
                            }
                        }
                    }
                }
            }else if(n_word[i] == 'l'){
                if(i < n_word.length-1) {
                    if (n_word[i + 1] == 'j') {
                        i++;
                    }
                }
            }else if(n_word[i] == 'n'){
                if(i < n_word.length-1) {
                    if (n_word[i + 1] == 'j') {
                        i++;
                    }
                }
            }else if(n_word[i] == 's'){
                if(i < n_word.length-1) {
                    if (n_word[i + 1] == '=') {
                        i++;
                    }
                }
            }else if(n_word[i] == 'z'){
                if(i < n_word.length-1) {
                    if (n_word[i + 1] == '=') {
                        i++;
                    }
                }
            }
            count++;
            //if(i == n_word.length-2){
            //    count++;
            //}
        }

        System.out.println(count);
    }
}
