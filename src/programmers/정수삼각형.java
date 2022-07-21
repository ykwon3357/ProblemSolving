package programmers;

public class 정수삼각형 {
	
	// 더 해주면서 내려감. 맨 마지막 행 최댓값
    // triangle[n][m] += Math.max(triangle[n-1][m], triangle[n-1][m-1])
    public int solution(int[][] triangle) {
        
        for(int i=1; i<triangle.length; i++){
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for(int j=1; j<i; j++){
                triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }

        int answer = 0;
        for(int num : triangle[triangle.length-1])
            if(answer < num) answer = num;
        
        return answer;
    }
}
