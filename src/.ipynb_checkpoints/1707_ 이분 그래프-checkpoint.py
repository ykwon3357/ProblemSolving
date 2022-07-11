# -*- coding: utf-8 -*-
# +
import sys
from collections import deque

def bfs(v, graph, visited):
    q = deque([v])
    visited[v] = 1

    while q:
        x = q.popleft()
        for nx in graph[x]:
            if not visited[nx]:
                q.append(nx)
                visited[nx] = visited[x] * (-1) # 다음꺼에 -1곱함
            elif visited[nx] == visited[x]: # 같으면 이분리스트 아님
                return 1
    return 0

for _ in range(int(sys.stdin.readline().rstrip())):
    v, e = map(int, sys.stdin.readline().rstrip().split())
    graph = [[] for _ in range(v+1)]
    visited = [0] * (v+1)

    for _ in range(e): # 인접리스트 생성
        a, b = map(int, sys.stdin.readline().rstrip().split())
        graph[a].append(b); graph[b].append(a)
 
    for i in range(1, v+1):
        if not visited[i]:
            if bfs(i, graph, visited):
                print('NO')
                break
    else:
        print('YES')
# -


