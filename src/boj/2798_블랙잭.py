n, m = map(int, input().split())
cards = list(map(int, input().split()))

maxCard, flag = 0, False
for i in range(n):
    for j in range(i+1, n):
        if cards[i] + cards[j] >= m:
            continue
        for k in range(j+1, n):
            sumCard = cards[i] + cards[j] + cards[k]
            if sumCard <= m and sumCard > maxCard:
                maxCard = sumCard
                if maxCard == m:
                    flag = True
                    break
        if flag:
            break
    if flag:
        break
print(maxCard)
