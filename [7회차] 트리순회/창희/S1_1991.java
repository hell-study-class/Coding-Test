package baeckjoon.weeks4.thursday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1991 {
    public static class Node{
        char name;
        Node left;
        Node right;
        Node top;
        public Node(Node left, Node top, Node right, char name){
            this.left = left;
            this.right = right;
            this.top = top;
            this.name = name;
        }
        public Node(char name){
            this.name = name;
            this.left = null;
            this.right = null;
            this.top = null;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] n_arr = new Node[26];
        for(int i=0; i<n; i++){
            n_arr[i] = new Node((char)('A'+ i));
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            char head = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left != '.'){
                n_arr[head-65].left = n_arr[left-65];
                n_arr[left-65].top = n_arr[head-65];
            }else{
                n_arr[head-65].left = null;
            }
            if(right != '.'){
                n_arr[head-65].right = n_arr[right-65];
                n_arr[right-65].top = n_arr[head-65];
            }else{
                n_arr[head-65].right = null;
            }
        }

        preOrderTraversal(n_arr[0]);
        System.out.println();
        inOrderTraversal(n_arr[0]);
        System.out.println();
        postOrderTraversal(n_arr[0]);

    }
    static void preOrderTraversal(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.name);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void inOrderTraversal(Node root){
        if(root == null){
            return ;
        }
        inOrderTraversal(root.left);
        System.out.print(root.name);
        inOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){
        if(root == null){
            return ;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.name);

    }

}
