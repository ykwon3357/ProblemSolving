n, m = map(int, input().split())

num = sorted(list(map(int, input().split())))
visited = [0]  n
arr = [0]  m
def backtracking(k)
    if k == m
        print(arr)
        return
    
    for i in range(n)
        if not visited[i]
            arr[k] = num[i]
            visited[i] = 1
            backtracking(k+1)
            visited[i] = 0

backtracking(0)