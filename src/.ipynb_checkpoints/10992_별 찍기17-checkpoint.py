# +
n = int(input())

for i in range(n-1):
    if i == 0:
        print(' '*(n-1-i)+'*')
    else:
        print(' '*(n-1-i)+'*'+' '*(2*i-1)+'*')
print('*'*(2*n-1))
