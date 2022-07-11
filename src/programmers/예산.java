package programmers;

public class 예산 {
	public int solution(int[] budgets, int M) {
        int tot = 0, low = 0, mid = 0, high = 0;
        
        for(int budget : budgets) {
            if(high < budget) high = budget;
        }

        while(low<=high){
            mid = (low + high)/2;
            
            tot = 0;
            for(int budget : budgets) {
                tot += (budget<=mid)?budget:mid;
                if(tot>M) break;
            }
            if(tot>M){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low-1;
    }

}
