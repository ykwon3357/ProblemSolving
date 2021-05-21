# 1. 뒤에서부터 a<b인 a,b 쌍 찾기
# 1-1. 못찾으면 -1 return
# 1-2. 찾으면 뒤부터 a보다 큰수 찾아서 a와 스왑
# 1-2. a 뒤부터 오름차순

n = int(input())

nums = list(map(int, input().split()))

for i in range(n-1,0,-1):
    if nums[i-1] < nums[i]:
        for j in range(n-1,i-1,-1):
            if nums[i-1] < nums[j]:
                nums[i-1], nums[j] = nums[j], nums[i-1]
                break
        nums = nums[:i] + sorted(nums[i:])
        print(*nums)
        break
else:
    print(-1)
