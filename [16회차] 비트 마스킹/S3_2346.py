from collections import deque


n, bs = int(input()), [0] + list(map(int, input().split()))
q = deque(list(range(1, n + 1)))
res = []
while q:
    x = q.popleft()
    r = bs[x]
    if r > 0:
        r -= 1
    res.append(x)
    q.rotate(-r)
print(*res)