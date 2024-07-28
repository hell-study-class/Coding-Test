import sys
from collections import deque

read = sys.stdin.readline
directions = [(-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)]
res = []

while True:
    graph, visited = [], []
    l, r, c = map(int, read().split())
    if not l and not r and not c:
        break

    q = deque()
    for F in range(l):
        floor = [list(map(lambda x: {'.': 0, '#': -1, 'S': 2, 'E': 3}[x], list(read().rstrip()))) for _ in range(r)]
        v_floor = [[0] * c for _ in range(r)]
        visited.append(v_floor)
        graph.append(floor)
        read()

    for f in range(l):
        for row in range(r):
            for col in range(c):
                if graph[f][row][col] == 2:
                    q.append((f, row, col))
                    graph[f][row][col] = 0
                if graph[f][row][col] == 3:
                    graph[f][row][col] = 0
                    t_f, t_r, t_c = f, row, col

    while q and not visited[t_f][t_r][t_c]:
        x, y, z = q.popleft()
        for d in directions:
            nx, ny, nz = x + d[0], y + d[1], z + d[2]
            if 0 <= nx < l and 0 <= ny < r and 0 <= nz < c and not visited[nx][ny][nz] and \
                    not graph[nx][ny][nz]:
                q.append((nx, ny, nz))
                visited[nx][ny][nz] = visited[x][y][z] + 1
    print(f'Escaped in {visited[t_f][t_r][t_c]} minute(s).' if visited[t_f][t_r][t_c] else 'Trapped!')