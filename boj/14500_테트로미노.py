# -*- coding: utf-8 -*-
# +
shapes = [
        [(0,0), (0,1), (0,2), (0,3)], # ㅡ
        [(0,0), (1,0), (2,0), (3,0)],
        [(0,0), (0,1), (1,0), (1,1)], # ㅁ
        [(0,1), (1,0), (1,1), (1,2)], # ㅗ
        [(0,0), (0,1), (0,2), (1,1)],
        [(0,0), (1,0), (2,0), (1,1)],
        [(1,0), (0,1), (1,1), (2,1)],
        [(1,0), (1,1), (0,1), (0,2)], # ㄱㄴ
        [(0,0), (1,0), (1,1), (2,1)],
        [(0,0), (0,1), (1,1), (1,2)],
        [(0,1), (1,0), (1,1), (2,0)],
        [(0,0), (1,0), (1,1), (1,2)], # ㄱ
        [(1,0), (1,1), (1,2), (0,2)],
        [(0,0), (1,0), (2,0), (0,1)],
        [(0,0), (0,1), (1,1), (2,1)],
        [(0,0), (0,1), (0,2), (1,0)],
        [(0,0), (0,1), (0,2), (1,2)],
        [(0,0), (1,0), (2,0), (2,1)],
        [(0,1), (1,1), (2,1), (2,0)],
        ]

n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

sumShape, maxShape, ans = 0, 0, 0

def solve(x, y):
    global maxShape
    for shape in shapes: # 모든 모양 반복
        sumShape = 0
        for i, j in shape: 
            if i+x >= n or j+y >= m: # 행, 열 넘어가면 중지
                break
            sumShape += matrix[i+x][j+y]
        if maxShape < sumShape:
            maxShape = sumShape
    return maxShape

for i in range(n): # 모든 좌표 탐색
    for j in range(m):
        ans = solve(i,j)
        
print(ans)
# -




