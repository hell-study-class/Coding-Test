import sys
from collections import deque

read = sys.stdin.readline

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def decrease():
    L = []
    for x in range(n):
        for y in range(m):
            if graph[x][y]:
                water = 0
                for d in directions:
                    nx, ny = x + d[0], y + d[1]
                    if 0 <= nx < n and 0 <= ny < m and not graph[nx][ny]:
                        water += 1
                L.append((x, y, water))
    for x, y, h in L:
        graph[x][y] = max(0, graph[x][y] - h)


def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = True

    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and \
                    graph[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))


n, m = map(int, read().split())
graph = [list(map(int, read().split())) for _ in range(n)]
res = 0
finish = False
while True:
    visited = [[False] * m for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and graph[i][j]:
                bfs(i, j)
                cnt += 1
            if cnt >= 2:
                finish = True
    if all(all(line[i] == 0 for i in range(m)) for line in graph):
        finish = True
        res = 0
    if finish:
        break
    decrease()
    res += 1
print(res)
