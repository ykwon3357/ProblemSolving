# +
n = int(input())

matrix = [list(map(int, input())) for _ in range(n)]

def dfs(x, y):
    global home

    if x <= -1 or x >= n or y <= -1 or y >= n:
        return 0

    if matrix[x][y]:
        matrix[x][y]=0

        dfs(x+1,y)
        dfs(x-1,y)
        dfs(x,y+1)
        dfs(x,y-1)

        home += 1
        return 1

    return 0

homes, home = [], 0
for i in range(n):
    for j in range(n):       
        if dfs(i, j):
            homes.append(home)
            home = 0 
     
print(len(homes))
for h in sorted(homes):
    print(h)
