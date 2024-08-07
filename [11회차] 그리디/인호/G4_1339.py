import heapq
from collections import defaultdict

def sol():
    step1 = defaultdict(int)
    step2 = {}
    heap = []
    for word in words:
        length = len(word)
        for i,w in enumerate(word):
            step1[w] += 10**(length - i -1)

    for key, value in step1.items():
        heapq.heappush(heap,[-value,key])

    point = 9
    while heap:
        w,p = heapq.heappop(heap)
        step2[p] = point
        point-=1

    total_sum =0
    for word in words:
        num = 0
        for char in word:
            num = num*10 + step2[char]
        total_sum+=num
    return total_sum

n = int(input())
words = [input() for _ in range(n)]
print(sol())