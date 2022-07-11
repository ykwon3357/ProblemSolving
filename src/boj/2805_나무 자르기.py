import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
trees = list(map(int, sys.stdin.readline().rstrip().split()))

left, right, height= 0, max(trees), 0
while left <= right:
    mid = (left + right)//2
    
    logs = 0 # 자른 나무 합
    for tree in trees:
        if tree > mid:
            logs += tree - mid
    
    if logs >= m: # 자른 나무 합이 많으면 톱 높이 증가   
        height = mid
        left = mid + 1
    else:
        right = mid -1

print(height)     