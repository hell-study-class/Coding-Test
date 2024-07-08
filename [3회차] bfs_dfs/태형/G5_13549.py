from collections import deque

n, k = map(int, input().split())
dist = [0] * 100_001
q = deque([n])
dist[n] = 1

while not dist[k]:
    x = q.popleft()
    if 2 * x < 100_001 and not dist[2 * x]:
        dist[2 * x] = dist[x]
        q.appendleft(2 * x)
    if x - 1 > -1 and not dist[x - 1]:
        dist[x - 1] = dist[x] + 1
        q.append(x - 1)
    if x + 1 < 100_001 and not dist[x + 1]:
        dist[x + 1] = dist[x] + 1
        q.append(x + 1)
print(dist[k] - 1)
