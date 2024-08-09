import sys
from heapq import heappop, heapify, heappush

read = sys.stdin.readline

cs = [int(read()) for _ in range(int(read()))]
heapify(cs)
r = 0
while len(cs) != 1:
    t = heappop(cs) + heappop(cs)
    r += t
    heappush(cs, t)
print(r)