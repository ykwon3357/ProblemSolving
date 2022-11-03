package programmers;

import java.util.*;

public class 디스크스케줄러 {

	public int solution(int[][] jobs) {
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
		Queue<int[]> waiting = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int answer = 0, idx = 0, time = 0;
		while (idx < jobs.length || !waiting.isEmpty()) {

			while (idx < jobs.length && jobs[idx][0] <= time) {
				waiting.offer(jobs[idx++]);
			}

			if (waiting.isEmpty()) {
				time = jobs[idx][0];
				continue;
			}

			int[] job = waiting.poll();
			time += job[1];
			answer += time - job[0];
		}
		return answer / jobs.length;
	}
}
