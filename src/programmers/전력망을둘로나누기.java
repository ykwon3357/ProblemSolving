package programmers;
import java.util.Arrays;

public class 전력망을둘로나누기 {
	
	int[][] map;
    int cnt;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        map = new int[n+1][n+1];
        for(int[] wire : wires){
            map[wire[0]][wire[1]] = map[wire[1]][wire[0]] = 1;
        }
        for(int[] wire : wires){
            cnt = 0;
            visited = new boolean[n+1];
            visited[1] = true;
            dfs(1, wire, n);
            answer = Math.min(Math.abs(n - cnt - cnt), answer);
        }
        
        return answer;
    }
    
    private void dfs(int start, int[] wire, int len){
        cnt++;
        for(int i=2; i<=len; i++){
            if((start == wire[0] && i == wire[1]) || 
               (start == wire[1] && i == wire[0])) continue;
            if(!visited[i] && map[start][i] == 1){
                visited[i] = true;
                dfs(i, wire, len);
            }
        }
    }

}
