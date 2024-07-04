import sys
from collections import deque

read = sys.stdin.readline

directions = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]


def sol(i, j):
    q = deque([(i, j)])
    graph[i][j] = 1
    while not graph[t_x][t_y]:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < I and 0 <= ny < I and not graph[nx][ny]:
                graph[nx][ny] = graph[x][y] + 1
                q.append((nx, ny))


res = []
for T in range(int(read())):
    I = int(read())
    graph = [[0] * I for _ in range(I)]
    x, y = map(int, read().split())
    t_x, t_y = map(int, read().split())
    sol(x, y)
    res.append(str(graph[t_x][t_y]-1))
print('\n'.join(res))