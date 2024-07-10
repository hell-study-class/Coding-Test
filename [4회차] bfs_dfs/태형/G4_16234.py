import sys
from collections import deque

read = sys.stdin.readline

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def check(x, y):
    for d in directions:
        nx, ny = x + d[0], y + d[1]
        if 0 <= nx < n and 0 <= ny < n and l <= graph[nx][ny] - graph[x][y] <= r:
            return True
    return False


def move(one, other):
    return (one + other) // 2


def sol(i, j):
    tmp = set()
    tmp.add((i, j))
    q = deque([(i, j)])

    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited and \
                    l <= abs(graph[nx][ny] - graph[x][y]) <= r:
                tmp.add((nx, ny))
                visited.add((nx, ny))
                q.append((nx, ny))
    tmp_sum = 0
    for x, y in tmp:
        tmp_sum += graph[x][y]
    tmp_sum //= len(tmp)
    for x, y in tmp:
        new_graph[x][y] = tmp_sum


n, l, r = map(int, read().split())
graph = [list(map(int, read().split())) for _ in range(n)]
cnt = 0
while True:
    flag = False
    visited = set()
    new_graph = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if (i, j) not in visited:
                flag = True
                visited.add((i, j))
                if check(i, j):
                    sol(i, j)
                else:
                    new_graph[i][j] = graph[i][j]
    graph = new_graph
    if not flag:
        break
    cnt += 1
print(cnt)