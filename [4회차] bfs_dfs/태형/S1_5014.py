from collections import deque

f, s, g, u, d = map(int, input().split())
visited = [0] * (f + 1)
q = deque([s])
visited[s] = 1

while q and not visited[g]:
    x = q.popleft()
    if x + u < f + 1 and not visited[x+u]:
        visited[x+u] = visited[x] + 1
        q.append(x+u)
    if x - d > 0 and not visited[x-d]:
        visited[x-d] = visited[x] + 1
        q.append(x-d)
print(visited[g]-1 if visited[g] else 'use the stairs')