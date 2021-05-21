# -*- coding: utf-8 -*-
# +
n, m = map(int, input().split())
visited = [0] * (n+1)

arr = [0]*m

def backtracking(k, idx): # 현재 k개까지 수를 택함
    if k == m: # m개 모두 택했으면
        print(*arr) # arr 출력
        return
    
    for i in range(idx, n+1): # idx 부터 n까지
        if not visited[i]: # 아직 i 방문 안했으면
            arr[k] = i # k번째수를 i로
            visited[i] = 1 # i 방문 표시
            backtracking(k+1, i+1) # 다음수 구하러 들어갈때 i+1부터 진행. 마치 이런느낌 for i in range(len(A)-1):
                                                                                         #for j in range(i+1, len(A)):
                                                                                            #if A[i] < A[j]:
            visited[i] = 0 # k번째 수를 i로 정한 모든 경우 다 확인 후 i 미사용 처리

backtracking(0, 1)            
# -




