package boj;

import java.io.*;
import java.util.*;

public class Main_11559_PuyoPuyo {

	static char[][] map;
	static int cnt;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][];
		
		for(int i=0; i<12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int ans = 0;
		while(find()) {
			print(map);
			down();
			print(map);
			ans++;
		}
		
		System.out.println(ans);
	}
	
	private static void down() {
		int dif = 0;
		boolean flag = false;
		
		for (int j = 0; j < map[0].length; j++) {
			
			for (int i = map.length-1; i >= 0; i--) {
				dif = 0; flag = false;
				if(map[i][j] == '.') {
					for (int k = i-1; k >= 0; k--) {
						if(map[k][j] != '.') {
							dif = i-k;
							flag = true;
							break;
						}
					}
					if(flag) {
						for(int k = i - dif; k >= 0; k--) {
							map[k+dif][j] = map[k][j];
							map[k][j] = '.';
						}
						i = map.length;
					}else {
						break;
					}
				}
			}
			
		}
	}
	
	private static boolean find() {
		boolean flag = false;
		visited = new boolean[12][6];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] != '.' && !visited[i][j]) {
					cnt = 0;
					count(i,j,map[i][j]);
					if(cnt >= 4) {
						bomb(i,j,map[i][j], new boolean[12][6]);
						flag = true;
					}
					
				}
			}
		}
		return flag;
	}
	
	private static void count(int x, int y, char color) {
		if(x<0 || x>= map.length || y<0 || y>=map[0].length || color != map[x][y] || visited[x][y]) return;
		cnt++;
		visited[x][y] = true;
		count(x+1, y, color);
		count(x-1, y, color);
		count(x, y+1, color);
		count(x, y-1, color);
	}
	
	private static void bomb(int x, int y, char color, boolean[][] visited) {
		if(x<0 || x>= map.length || y<0 || y>=map[0].length || color != map[x][y] || visited[x][y]) return;
		map[x][y] = '.';
		visited[x][y] = true;
		bomb(x+1, y, color, visited);
		bomb(x-1, y, color, visited);
		bomb(x, y+1, color, visited);
		bomb(x, y-1, color, visited);
	}

	
	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
