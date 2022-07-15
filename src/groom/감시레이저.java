package groom;

import java.io.*;
import java.util.*;

public class 감시레이저 {
	// solve : 배열 탐색 하면서 감시레이저 유형에 맞게 방문체크
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] skipRow = new boolean[N]; // 방문체크 스킵할 행
		boolean[] skipCol = new boolean[M]; // 방문체크 스킵할 열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !skipRow[i]) { // 1번 감시레이저이고 스킵할 행이 아니면
					skipRow[i] = true; // 스킵할 행 추가
					for (int k = 0; k < M; k++) { // 1번 레이저이므로 행 방문체크
						visited[i][k] = true;
					}
				} else if (map[i][j] == 2 && !skipCol[j]) {
					skipCol[j] = true;
					for (int k = 0; k < N; k++) {
						visited[k][j] = true;
					}
				} else if (map[i][j] == 3) {
					if (!skipRow[i]) {
						skipRow[i] = true;
						for (int k = 0; k < M; k++) {
							visited[i][k] = true;
						}
					}
					if (!skipCol[j]) {
						skipCol[j] = true;
						for (int k = 0; k < N; k++) {
							visited[k][j] = true;
						}
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j])
					ans++;
			}
		}
		System.out.println(ans);
	}

}
