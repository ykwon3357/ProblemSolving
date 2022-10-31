package programmers;

public class 이상한문자만들기 {
	public String solution(String s) {

		String[] sArr = s.split("");

		int k = 0;
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i].equals(" ")) {
				k = 0;
			} else {
				if (k % 2 == 0) {
					sArr[i] = sArr[i].toUpperCase();
				} else {
					sArr[i] = sArr[i].toLowerCase();
				}
				k++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String sa : sArr) {
			sb.append(sa);
		}
		return sb.toString();
	}

}
