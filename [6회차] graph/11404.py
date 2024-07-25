import sys

read = sys.stdin.readline
INF = int(1e9)

n, m = int(read()), int(read())
graph = [[INF] * n for _ in range(n)]

for _ in range(m):
    a, b, c = map(int, read().split())
    graph[a-1][b-1] = min(graph[a-1][b-1], c)

for i in range(n):
    graph[i][i] = 0

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(n):
    for j in range(n):
        print(0 if (graph[i][j] == INF or i == j) else graph[i][j], end=' ')
    print()