package programmers;

import java.util.*;

public class 게임맵최단거리 {

	public static void main(String[] args) {
		게임맵최단거리 sol = new 게임맵최단거리();
		int[][] maps = new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		System.out.println(sol.solution(maps));

	}

	public int solution(int[][] maps) {

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		int point[] = null, nx = 0, ny = 0, x = 0, y = 0, N = maps.length, M = maps[0].length;
		int[] dx = new int[] { -1, 1, 0, 0 };
		int[] dy = new int[] { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			point = q.poll();
			x = point[0];
			y = point[1];
			if (x == N - 1 && y == M - 1)
				break;

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (maps[nx][ny] == 1) {
					maps[nx][ny] += maps[x][y];
					q.offer(new int[] { nx, ny });
				}
			}
		}

		return (maps[N - 1][M - 1] == 1) ? -1 : maps[N - 1][M - 1];
	}
}
