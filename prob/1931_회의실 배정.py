import sys

meetings = []

n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    start, end = map(int, sys.stdin.readline().rstrip().split())
    meetings.append((start, end))

# 회의 시작시간, 종료시간 순으로 각각 정렬
meetings.sort(key = lambda x : x[0])
meetings.sort(key = lambda x : x[1])

endTime, ans = 0, 0
for start, end in meetings:
    if endTime <= start: # 시작시간이 종료시간 이후면
        endTime = end # 종료시간 최신화
        ans += 1 # 회의 수 증가

print(ans)
