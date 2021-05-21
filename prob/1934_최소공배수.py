# +
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a%b)

t = int(input())
for i in range(t):
    a, b = map(int, input().split())
    print(a*b//gcd(a, b))
    
