package softeer;


import java.util.*;
import java.io.*;


public class 좌석관리
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+2][M+2];
        for(int i=1; i<=N; i++){
            Arrays.fill(map[i], 1000);
        }
        boolean[] ate = new boolean[10001];
        boolean[] seated = new boolean[10001];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            int id = Integer.parseInt(st.nextToken());

            if(action.equals("In")){
                if(ate[id]){ 
                    if(!seated[id]){ // 이미 밥을 먹고 좌석을 떠났다면 already ate lunch
                        sb.append(id).append(" already ate lunch.\n");
                    }else{ // 밥먹고 앉아 있었다면 already seated
                        sb.append(id).append(" already seated.\n");
                    }
                }else{
                    // 배정
                    int[] location = locate(map, N, M, id);
                    
                    if(location != null){ // - 배정 성공 gets the seat
                        ate[id] = true;
                        seated[id] = true;
                        sb.append(id).append(" gets the seat (").append(location[0]).append(", ").append(location[1])
                        .append(").\n");
                    }else{// - 배정 실패 There are no more seats.
                        sb.append("There are no more seats.\n");
                    }         
                }
                
            }else{
                if(ate[id]){ 
                    if(!seated[id]){ // 이미 밥을 먹고 좌석을 떠났다면 already left seat
                        sb.append(id).append(" already left seat.\n");
                    }else{ // 밥먹고 앉아 있었다면 leaves from the seat
                        int[] location = getOut(map, N, M, id);
                        seated[id] = false;
                        sb.append(id).append(" leaves from the seat (").append(location[0]).append(", ").append(location[1])
                        .append(").\n");
                    }
                }else{ // 아직 밥을 먹지 못했다면 didn't eat lunch
                     sb.append(id).append(" didn't eat lunch.\n");
                }

            }
        }
        System.out.println(sb);
    }
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    private static int[] locate(int[][] map, int N, int M, int id){
        int maxSafe = 0, x = 0, y = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(maxSafe < map[i][j]){
                    maxSafe = map[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        if(maxSafe == 0) return null; // 좌석 배정 실패

        // 앉히고 (-id) 상하좌우 못앉게 표시(0)
        map[x][y] = -id;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];           
            map[nx][ny] = 0;
        }
        updateSafetyScore(map, N, M); // 앉을 수 있는 좌석들 안전도 갱신

        return new int[]{x, y};
    }

    private static int[] getOut(int[][] map, int N, int M, int id){
        // 사원 자리 찾기
        int x = 0, y = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] == -id){
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        map[x][y] = 1000;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];           
            map[nx][ny] = 1000;
        }
        updateSafetyScore(map, N, M); // 앉을 수 있는 좌석들 안전도 갱신

        return new int[]{x, y};
    }

    private static void updateSafetyScore(int[][] map, int N, int M){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] > 0){
                    for(int k=1; k<=N; k++){
                        for(int l=1; l<=M; l++){
                            if(i==k && j==l) continue;
                            if(map[k][l] < 0){
                                map[i][j] = Math.min(map[i][j], (i-k)*(i-k) + (j-l)*(j-l));
                            }
                        }
                    }
                }
            }
        }
    }
}
