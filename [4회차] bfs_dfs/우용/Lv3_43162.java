class Solution {
    public static int node ;
    public static int[][] graph;
    public static int[] visited;
    public static int count = 0;
    public static boolean status = false;
    public static int solution(int n, int[][] computers) {
        node = n;

        graph = computers;
        visited = new int[computers.length];

        for(int i = 0; i< n; i++){
            status = false;
            dfs(i);
            if(status){
                count++;
            }
        }

        return count;
    }

    public static void dfs(int index){
        for(int i = 0 ; i<node; i++){
            if(graph[index][i] == 1 && visited[i] ==0){
                visited[i] = 1;
                status=true;
                dfs(i);
            }
        }
    }
}