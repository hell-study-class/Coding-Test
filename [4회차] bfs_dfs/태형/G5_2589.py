import sys
from collections import deque

read = sys.stdin.readline

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def sol(i, j):
    q = deque([(i, j)])
    visited = [[0] * w for _ in range(l)]
    visited[i][j] = 1
    ret = 0
    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < l and 0 <= ny < w and not visited[nx][ny] and \
                    graph[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))
                ret = max(ret, visited[nx][ny])
    return ret - 1


l, w = map(int, read().split())
graph = [list(map(lambda x: {'W': 0, 'L': 1}[x], list(read().rstrip()))) for _ in range(l)]
res = 0

for i in range(l):
    for j in range(w):
        if graph[i][j]:
            res = max(res, sol(i, j))
print(res)
