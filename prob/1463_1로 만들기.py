# +
n = int(input())
d = [0]*(n+1)
d[1] = 0

# d[k] = min(d[k//3]+1, d[k//2]+1, d[k-1]+1)
for i in range(2, n+1):
    d[i] = d[i-1] + 1
    if i%2 == 0:
        d[i] = min(d[i], d[i//2]+1)
    if i%3 == 0:
        d[i] = min(d[i], d[i//3]+1)
print(d[n])
