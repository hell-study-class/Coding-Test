import sys
from heapq import heappush, heappop

read = sys.stdin.readline

ts = sorted([list(map(int, read().split())) for _ in range(int(read()))], key=lambda x: (x[0], x[1]))
hq = [ts[0][1]]

for t in ts[1:]:
    if hq[0] <= t[0]:
        heappop(hq)
    heappush(hq, t[1])
print(len(hq))