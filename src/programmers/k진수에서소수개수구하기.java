package programmers;

public class k진수에서소수개수구하기 {
	public int solution(int n, int k) {
		int answer = 0;
		String[] nums = Integer.toString(n, k).split("0");
		for (String num : nums) {
			if (num.equals(""))
				continue;
			if (isPrime(num))
				answer++;
		}
		return answer;
	}

	private boolean isPrime(String num) {
		long n = Long.parseLong(num);
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
