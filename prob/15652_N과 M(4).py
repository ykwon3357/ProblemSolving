# +
n, m = map(int, input().split())
#visited = [0] * (n+1)
arr = [0] * m
def backtracking(k, idx):
    if k == m:
        print(*arr)
        return
    
    for i in range(idx, n+1):
        arr[k] = i   
        backtracking(k+1, arr[k])

backtracking(0, 1)
# -




