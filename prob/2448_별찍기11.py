import math

# 붙이고 띄우고
# n = 3x2^k 일때 3x2^(k-1) 만큼 shift
star = ['  *  ', ' * * ','*****']
def makeStar(shift):
    for i in range(len(star)):
        star.append(star[i] + ' ' + star[i])
        star[i] = ('   '*shift + star[i] + '   '*shift)

n = int(input())
k = int(math.log(n//3, 2))

for i in range(k):
    makeStar(2**i)
for i in range(n):
    print(star[i])