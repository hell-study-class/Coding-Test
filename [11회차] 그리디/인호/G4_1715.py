import heapq

n = int(input())
heap = []
for _ in range(n):
    heapq.heappush(heap,int(input()))

res = 0
while len(heap) > 1:
    n1 = heapq.heappop(heap)
    n2 = heapq.heappop(heap)
    res+=n1+n2
    heapq.heappush(heap,n1+n2)

print(res)