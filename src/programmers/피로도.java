class 피로도 {
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, 0, new boolean[dungeons.length]);

        return answer;
    }
    
    int answer = 0;
    
    private void dfs(int k, int[][] dungeons, int depth, boolean[] visited){
        answer = Math.max(answer, depth);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1, visited);
                visited[i] = false;
            }     
        }
    }
}
