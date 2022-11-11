package programmers;
import java.util.*;

public class 가장먼노드 {
    
	public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        int temp[] = null, max = 0, dist[] = new int[n+1];
        dist[1] = -1;
        while(!q.isEmpty()){
            temp = q.poll();
            if(max < temp[1]) max = temp[1];
            
            for(int next : graph[temp[0]]){
                if(dist[next] == 0){
                    dist[next] = temp[1] + 1;
                    q.offer(new int[]{next, temp[1]+1});
                }
            }
        }

        for(int d : dist){
            if(d == max) answer++;
        }
        return answer;
    }
	
}
