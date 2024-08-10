import heapq
import sys

read = sys.stdin.readline

n = int(read())
arr = list(map(int,read().split()))
heapq.heapify(arr)

smallest_num = 1
while arr:
    num = heapq.heappop(arr)
    if num > smallest_num:
        break
    smallest_num+=num
print(smallest_num)
