# -*- coding: utf-8 -*-
# +
a, b = map(int, input().split())
oa, ob = a, b

while b: # 유클리드 호제법
    t = b
    b = a % b
    a = t

print(a)
print(oa*ob//a)
# -


