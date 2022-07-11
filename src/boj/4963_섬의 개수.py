import sys
sys.setrecursionlimit(10**5) # recursion error 방지(파이썬 재귀 깊이 기본 1000으로 설정되어있음)

testcase= []
while True: # 입력
    w, h = map(int, input().split())
    if w+h == 0:
        break
    testcase.append([list(map(int, input().split())) for i in range(h)])

def dfs(x, y, matrix): # dfs 정의
    if x <= -1 or x >= len(matrix) or y <= -1 or y >= len(matrix[0]):
        return 0

    if matrix[x][y]:
        matrix[x][y] = 0

        dx= [0,0,-1,1,1,1,-1,-1]
        dy= [-1,1,0,0,-1,1,-1,1]
        for i in range(8):
            nx = x+dx[i]
            ny = y+dy[i]
            dfs(nx, ny, matrix)   
        return 1

    return 0

ans = []
for matrix in testcase: # 각 케이스별로 섬의 개수 구하기
    land = 0
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if dfs(i, j, matrix):
                land += 1
    ans.append(land)

for a in ans: # 출력
    print(a)