import sys
from heapq import heapify, heappop, heappush

read = sys.stdin.readline
n, k = map(int, read().split())
js = [list(map(int, read().split())) for _ in range(n)]
heapify(js)
cs = sorted(list(int(input()) for _ in range(k)))
res = 0
tmp = []
for c in cs:
    while js and c >= js[0][0]:
        heappush(tmp, -heappop(js)[1])
    if tmp:
        res += -heappop(tmp)
    elif not js:
        break
print(res)