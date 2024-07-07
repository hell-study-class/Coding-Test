import sys
from collections import deque

read = sys.stdin.readline

directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]


def sol(i=0, j=0):
    q = deque([(i, j)])
    visited[i][j] = 1

    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and \
                    graph[nx][ny]:
                q.append((nx, ny))
                visited[nx][ny] = visited[x][y] + 1


n, m = map(int, read().split())
graph = [list(map(int, list(read().rstrip()))) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
sol()
print(visited[n-1][m-1])