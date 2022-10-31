package programmers;

class 여행경로 {
	
    boolean[] isUsed;
    StringBuilder sb = new StringBuilder();
    String res = "J";
    
    public String[] solution(String[][] tickets) {
        isUsed = new boolean[tickets.length];
        sb.append("ICN ");
        dfs("ICN", 0, tickets);
        String[] answer = res.split(" ");
        return answer;
    }
    
    private void dfs(String start, int depth, String[][] tickets){
        if(depth == tickets.length){
            res = (res.compareTo(sb.toString())>0)?sb.toString():res;
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(!isUsed[i] && tickets[i][0].equals(start)){
                isUsed[i] = true;
                sb.append(tickets[i][1]).append(" ");
                dfs(tickets[i][1], depth+1, tickets);
                sb.delete(sb.length()-4, sb.length());
                isUsed[i] = false;
            }
        }
    }
}
