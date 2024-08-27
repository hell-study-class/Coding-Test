from collections import deque

directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

def solution(maps):
    n, m = len(maps), len(maps[0])
    q = deque([(0, 0)])
    visited = [[0] * m for _ in range(n)]
    visited[0][0] = 1
    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x + d[0], y + d[1]
            if 0 <= nx < n and 0 <= ny < m and \
                not visited[nx][ny] and maps[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))
    return visited[n-1][m-1] if visited[n-1][m-1] else -1