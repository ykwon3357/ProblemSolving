package groom;

import java.io.*;
import java.util.*;

public class 지뢰찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N+2][M+2];
		char[] temp;
		for(int i=1; i<=N; i++) {
			temp = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = temp[j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				sb.append((map[i][j] == '.')?getMineCnt(map, i, j):"*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static String getMineCnt(char[][] map, int x, int y) {
		int cnt = 0;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(map[i][j] == '*') cnt++;
			}
		}
		return cnt+"";
	}

}

