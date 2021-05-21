# -*- coding: utf-8 -*-
# +
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
graph = [[]*(n+1) for _ in range(n+1)]
visited = [0]*(n+1)

for i in range(m):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    visited[v] = 1
    #print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

cnt = 0 #dfs 실행횟수
for i in range(1, n+1):
    if not visited[i]:
        dfs(i)
        cnt += 1

print(cnt)
