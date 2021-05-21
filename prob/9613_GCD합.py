# +
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a%b)

t = int(input())
num = []
for i in range(t):
    num = list(map(int, input().split()))
    sumGcd = 0
    for j in range(1, len(num)-1):
        for k in range(j+1, len(num)):
            sumGcd += gcd(num[j], num[k])
    print(sumGcd)
# -


