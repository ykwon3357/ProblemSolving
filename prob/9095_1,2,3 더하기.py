# +
#d[n] = d[n-1] + d[n-2] + d[n-3]

nArr = [int(input()) for _ in range(int(input()))]

d = [0, 1, 2, 4]
for i in range(4, max(nArr)+1):
    d.append(d[i-1] + d[i-2] + d[i-3])

for i in nArr:
    print(d[i])
