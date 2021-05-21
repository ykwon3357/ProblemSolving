# -*- coding: utf-8 -*-
# +
#시간초과
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
    flag = True
    for i in range(2, n-1):
        for j in range(n-2, 1, -1):
            if numArr[i]*numArr[j]:
                if n == (i+j):
                    print('{} = {} + {}'.format(n, i, j))
                    flag = False
                    break
        if not flag:
            break
    if flag:
        print("Goldbach's conjecture is wrong.")

