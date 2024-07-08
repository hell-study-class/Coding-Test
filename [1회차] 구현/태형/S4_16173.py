import sys
from collections import deque

read = sys.stdin.readline

directions = [(0, 1), (1, 0)]

n = int(read())
graph = [list(map(int, read().split())) for _ in range(n)]
visited = set()
q = deque([(0, 0)])
visited.add((0, 0))

while q:
    x, y = q.popleft()
    for d in directions:
        nx, ny = x + d[0] * graph[x][y], y + d[1] * graph[x][y]
        if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited:
            q.append((nx, ny))
            visited.add((nx, ny))
print('HaruHaru' if (n-1, n-1) in visited else 'Hing')
