from collections import deque

n, k = map(int, input().split())
visited = [0] * 100_001
parent = [0] * 100_001
res = []
q = deque([n])
visited[n] = 1

while q and not visited[k]:
    x = q.popleft()
    if 2 * x < 100_001 and not visited[2 * x]:
        visited[2 * x] = visited[x] + 1
        parent[2 * x] = x
        q.append(2 * x)
    if x - 1 > -1 and not visited[x - 1]:
        visited[x - 1] = visited[x] + 1
        parent[x-1] = x
        q.append(x - 1)
    if x + 1 < 100_001 and not visited[x + 1]:
        visited[x + 1] = visited[x] + 1
        parent[x+1] = x
        q.append(x + 1)

m = k
while m != n:
    res.append(m)
    m = parent[m]
res.append(n)
print(visited[k] - 1)
print(*res[::-1])
