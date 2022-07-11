# n = 3일때 가운데를 비워두고 "별"이 찍힌것처럼
# n = 3^i 일때 가운데를 비워두고 "3^(i-1)의 별 배열"이 찍힘
def star(n):
    global matrix
    if n == 3:
        matrix[0][:3] = matrix[2][:3] = [1]*3
        matrix[1][:3] = [1,0,1]
        return
    
    a = n//3
    star(a)
    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue
            for k in range(a):
                matrix[a*i+k][a*j:a*(j+1)] = matrix[k][:a]

n = int(input())
matrix = [[0]*n for _ in range(n)]
star(n)
for i in matrix:
    for j in i:
        print('*' if j else ' ', end='')
    print()