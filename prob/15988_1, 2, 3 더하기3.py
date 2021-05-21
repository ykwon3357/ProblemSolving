# +
t = int(input())
numArr = [int(input()) for i in range(t)]

d = [0, 1, 2, 4]

for i in range(4, max(numArr)+1):
    d.append((d[i-1] + d[i-2] + d[i-3])%1000000009)

for num in numArr:
    print(d[num])
