package programmers;

public class 기지국설치 {
	// if 연속된 전파 필요 아파트 수 > (전파도달거리*2+1)
    //    + 올림 (연속된 전파 필요 아파트 수 / (전파도달거리*2+1))
    // else + 1
	public static void main(String[] args) {
		System.out.println('A'>'B');
		System.out.println('A'<'B');
	}
    public int solution(int n, int[] stations, int w) {
        int answer = 0, preStation = -w, aptCnt = 0;
        double waveDist = w*2 + 1;

        for(int station : stations){
            aptCnt = (station - w) - (preStation + w) - 1;
            preStation = station;
            if(aptCnt > 0) answer += (aptCnt > waveDist) ? Math.ceil(aptCnt/waveDist) : 1;
        }
        aptCnt = n - (preStation + w);
        if(aptCnt > 0) answer += (aptCnt > waveDist) ? Math.ceil(aptCnt/waveDist) : 1;
        
        return answer;
    }
}
