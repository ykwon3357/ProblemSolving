package boj;
import java.io.*;
import java.util.*;

public class Main1194_유경원 {
	
	/*
	 * 비트마스킹으로 key 관리 하면서 조건에 따라 bfs
	 */

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int N, M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static Queue<int[]> q;
	static boolean visited[][][]; // 3번째열 key 관리
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		char[] temp;
		int sx = 0, sy = 0;
		for(int i=0; i<N; i++) {
			temp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(temp[j]=='0') {
					sx = i;
					sy = j;
				}
				map[i][j] = temp[j];
			}
		}
		
		q = new ArrayDeque<int[]>();
		q.offer(new int[] {sx,sy,0,0});
		visited = new boolean[N][M][64];
		visited[sx][sy][0] = true;
		System.out.println(bfs());
	}
	
	private static int bfs() {
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0], y = t[1], cnt = t[2], keys = t[3];
			
			if(map[x][y]=='1') {
				return cnt;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<=-1 || nx>=N || ny<=-1 || ny>=M || map[nx][ny]=='#' || visited[nx][ny][keys]) continue;
				
				
				if(map[nx][ny]>=97 && map[nx][ny]<=102) { // 열쇠면
					int newkey = (1<<(map[nx][ny]-'a')) | keys; // 열쇠추가
					if(!visited[nx][ny][newkey]) {
						visited[nx][ny][newkey] = true; // 새로운 키 방문체크
						visited[nx][ny][keys] = true; // 기존 방문체크
						q.offer(new int[] {nx, ny, cnt+1, newkey});
					}
				}else if(map[nx][ny]>=65 && map[nx][ny]<=70) { // 문 이면
					if((keys & ( 1<<(map[nx][ny]-'A')) ) > 0) { // 문에 해당하는 키가 있다면
						visited[nx][ny][keys] = true;
						q.offer(new int[] {nx, ny, cnt+1, keys});
					}
				}else {
					visited[nx][ny][keys] = true;
					q.offer(new int[] {nx, ny, cnt+1, keys});
				}
			}
		}
		return -1;
		
	}
	
}
