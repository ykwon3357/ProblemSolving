# 시간초과 요인 https://www.acmicpc.net/board/view/44906
# 위 글 3번 반영

import sys

t = 0
testcase = []
while t < 100000:
    n = int(sys.stdin.readline().rstrip())
    if n == 0:
        break
    testcase.append(n)
    t += 1

numArr = [1 for i in range(max(testcase))]

for i in range(2, len(numArr)//2):
    if numArr[i]:
        for j in range(i+i, len(numArr), i):
            numArr[j] = 0

for n in testcase:
    for i in range(n-2, 1, -1):
        if numArr[i]*numArr[n-i]:
            print('{} = {} + {}'.format(n, n-i, i))
            break
    else:
        print("Goldbach's conjecture is wrong.")
