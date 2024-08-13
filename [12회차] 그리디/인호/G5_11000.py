import heapq
import sys

input = sys.stdin.readline

n = int(input())
cls = []
for _ in range(n):
    heapq.heappush(cls,list(map(int,input().split())))

cnt = 0
line = []
while cls:
    f,e = heapq.heappop(cls)
    if not line:
        heapq.heappush(line,e)
        cnt+=1
    else:
        if f >= line[0]:
            heapq.heappop(line)
            heapq.heappush(line,e)
        else:
            heapq.heappush(line,e)
            cnt+=1
print(cnt)
