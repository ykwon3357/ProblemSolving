# +
e,s,m,year = 1,1,1,1

e_in, s_in, m_in = map(int, input().split())
while(True):
    if e == e_in and s == s_in and m == m_in:
        break
    e += 1
    s += 1
    m += 1
    year += 1
    if e > 15:
        e -= 15
    if s > 28:
        s -= 28
    if m > 19:
        m -= 19
        
print(year)
# -


