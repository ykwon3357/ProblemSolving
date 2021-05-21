# +
#d[n] = d[n-1] + d[n-2]

n = int(input())
d = [0, 1, 3]
for i in range(3, n+1):
    d.append(d[i-1] + d[i-2] * 2)

print(d[n]%10007)
# -




