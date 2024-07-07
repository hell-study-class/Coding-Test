import sys
from collections import deque

read = sys.stdin.readline
directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]


def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = True
    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and \
                    graph[nx][ny] == graph[i][j]:
                visited[nx][ny] = True
                q.append((nx, ny))


n = int(read())
graph = [list(map(lambda x: {'R': 0, 'G': 1, 'B': 2}[x], list(read().rstrip()))) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
c1, c2 = 0, 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            c1 += 1

visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not graph[i][j]:
            graph[i][j] = 1

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            c2 += 1
print(c1, c2)
