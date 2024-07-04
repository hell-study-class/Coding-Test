import sys
from collections import deque

read = sys.stdin.readline

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def sol(i, j):
    q = deque([(i, j)])
    visited[i][j] = True
    ret = 1
    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))
                ret += 1
    return ret


n, m, k = map(int, read().split())
visited = [[False] * n for _ in range(m)]
res = []
for _ in range(k):
    x1, y1, x2, y2 = map(int, read().split())
    for x in range(x1, x2):
        for y in range(y1, y2):
            if not visited[x][y]:
                visited[x][y] = True

for i in range(m):
    for j in range(n):
        if not visited[i][j]:
            res.append(sol(i, j))

print(len(res))
print(*sorted(res))
