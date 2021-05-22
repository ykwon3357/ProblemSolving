import sys

n, m, v = map(int, sys.stdin.readline().rstrip().split())

#인접 행렬
matrix = [[0]*(n+1) for _ in range(n+1)]
visited = [0]*(n+1)
for _ in range(m):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    matrix[x][y] = matrix[y][x] = 1

def dfs(v):
    visited[v] = 1
    print(v, end=' ')

    for i in range(1, n+1):
        if not visited[i] and matrix[i][v]:
            dfs(i)

def bfs(v):
    q = [v]
    visited[v] = 0
    while q:
        v = q.pop(0)   
        print(v, end=' ')

        for i in range(1, n+1):
            if visited[i] and matrix[i][v]:
                q.append(i)
                visited[i] = 0

dfs(v)
print()
bfs(v)