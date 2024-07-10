import sys
from collections import deque

read = sys.stdin.readline

directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

def sol(i: int, j: int):
    q = deque([(i, j)])
    visited.add((i, j))
    ret = 1
    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < m and \
                (nx, ny) not in visited and graph[nx][ny]:
                visited.add((nx, ny))
                q.append((nx, ny))
                ret += 1
    return ret
    

n, m, k = map(int, read().split())
graph = [[False] * m for _ in range(n)]
visited = set()
res = 0
for _ in range(k):
    r, c = map(lambda x: x-1, map(int, read().split()))
    graph[r][c] = True

for i in range(n):
    for j in range(m):
        if (i, j) not in visited and graph[i][j]:
            res = max(res, sol(i, j))
print(res)