# +
n = int(input())

for i in range(2*n-1):
    for j in range(n-abs(n-1-i)):
        print('*', end='')
    for j in range(2*abs(n-1-i)):
        print(' ', end='')
    for j in range(n-abs(n-1-i)):
        print('*', end='')
    print()
