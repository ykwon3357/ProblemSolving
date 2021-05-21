# +
n, m = map(int, input().split())
visited = [0] * (n+1)
arr = [0] * m
           
def backtracking(k):
    if k == m:
        print(*arr)
        return
    
    for i in range(1, n+1):
        arr[k] = i
        backtracking(k+1)

backtracking(0)
# -




