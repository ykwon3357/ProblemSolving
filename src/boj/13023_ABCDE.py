# -*- coding: utf-8 -*-
# +
import sys

def dfs(v, depth):
    global ans
    visited[v] = True
    if depth == 5: # depth 5면 끝
        ans = 1
        return
    
    for i in graph[v]: # 인접 노드 조사
        if not visited[i]: 
            dfs(i, depth+1)
            visited[i] = False # 다음 조사를 위해 false로

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * n
ans = 0

for i in range(m): # 인접리스트
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n): 
    if not visited[i]:
        dfs(i, 1)
        visited[i] = False # 다음 조사를 위해 false로
        if ans:
            break

print(ans)
