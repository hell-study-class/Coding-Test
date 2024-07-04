import sys
from collections import deque

read = sys.stdin.readline

directions = [(1, 0, 0), (-1, 0, 0), (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)]


def check():
    ret = 0
    for floor in graph:
        for row in floor:
            for elem in row:
                if not elem:
                    return -1
                ret = max(ret, elem)
    return ret - 1


m, n, h = map(int, read().split())
graph = []
q = deque()
res = 0
for floor in range(h):
    graph.append([list(map(int, read().split())) for _ in range(n)])

for k in range(h):
    for i in range(n):
        for j in range(m):
            if graph[k][i][j] == 1:
                q.append((k, i, j))

while q:
    z, x, y = q.popleft()
    for d in directions:
        nz, nx, ny = z + d[0], x + d[1], y + d[2]
        if 0 <= nz < h and 0 <= nx < n and 0 <= ny < m and not graph[nz][nx][ny]:
            graph[nz][nx][ny] = graph[z][x][y] + 1
            q.append((nz, nx, ny))
print(check())
