# +
import math

n = int(input())
numList = list(map(int, input().split()))

cnt = 0
for num in numList:
    if num == 1:
        continue
    for i in range(2, int(math.sqrt(num))+1):
        if num % 2 == 0:
            break
    else:
        cnt += 1
        
print(cnt)

# +
numList = [1]*1001
numList[0], numList[1] = 0, 0

for i in range(2, len(numList)):
    if numList[i]:
        for j in range(i+i, len(numList), i):
            if numList[j]:
                numList[j] = 0

n = int(input())
cnt = 0
for i in list(map(int, input().split())):
    if numList[i]:
        cnt += 1

print(cnt)
# -


