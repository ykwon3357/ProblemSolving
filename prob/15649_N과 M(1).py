# -*- coding: utf-8 -*-
# +
n, m = map(int, input().split())
visited = [False] * (n+1)

arr = [0] * (m)

def backtracking(k): # 현재 k개까지 수를 택함
    if(k == m): # m개 모두 택했으면
        print(*arr) # arr 다 출력
        return
    
    for i in range(1, n+1): # 1부터 n까지
        if not visited[i]: # 아직 i 방문 안했으면
            arr[k] = i # k번째 수를 i로
            visited[i] = True # i 방문표시          
            backtracking(k + 1) # 다음 수 정하러 한 단계 더 들어감
            visited[i] = False # k번째 수를 i로 정한 모든 경우에 다 확인 했으니 i를 이제 사용되지 않았다고 처리
            
backtracking(0)
