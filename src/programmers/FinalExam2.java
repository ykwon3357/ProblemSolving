package programmers;

import java.io.*;
import java.util.*;
public class FinalExam2 {

	public static void main(String[] args) throws IOException {
		FinalExam2 sol = new FinalExam2();
		int[][] queries = new int[][] {{3,2}, {3,2}, {2,2}, {3,2}, {1,4}, {3,2}, {2,3}, {3,1}};
		print(sol.solution(3, 4, 2, queries));
	}
	
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
    
	public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        int x = 0, y = 0;
        
        for(int[] query : queries){
        	print(answer);
        	
            x = query[0]-1;
            y = query[1]-1;
            if(answer[x][y] == max_virus){
                spreadVirus(x, y, rows, columns, max_virus, answer);
            }else{
                answer[x][y]++;
            }
        }
        return answer;
    }
	
	int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    Queue<int[]> q = new ArrayDeque<>();

	private void spreadVirus(int x, int y, int rows, int columns, int max_virus, int[][] answer) {
		q.offer(new int[]{x,y});
        boolean[][] visited = new boolean[rows][columns];
        int nx = 0, ny = 0, temp[] = null;
        while(!q.isEmpty()){
            temp = q.poll();
            x = temp[0];
            y = temp[1];
            
            for(int i=0; i<4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx<0 || nx >= rows || ny<0 || ny >= columns || visited[nx][ny]) continue;
                if(answer[nx][ny] == max_virus){
                    q.offer(new int[]{nx,ny});
                }else{
                    answer[nx][ny]++;
                }
                visited[nx][ny] = true;
            }
        }
	}
	
}
