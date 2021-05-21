# +
height = []
for i in range(9):
    height.append(int(input()))

sumHeight, del1, del2 = sum(height), 0, 0

for i in range(8):
    for j in range(i + 1, 9):
        if sumHeight - height[i] - height[j] == 100:
            del1 = height[i]
            del2 = height[j]
            height.remove(del1)
            height.remove(del2)
            break
    if del1:
        break

for h in sorted(height):
    print(h)
    
# -




