import sys

read = sys.stdin.readline
INF = int(1e6)
n, m = map(int, read().split())
graph = [[INF] * n for _ in range(n)]

for _ in range(m):
    a, b = map(lambda x: x-1, map(int, read().split()))
    graph[a][b] = 1
    graph[b][a] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(n):
    graph[i][i] = 0

res = [-1, INF]
for i in range(n):
    s = sum(graph[i])
    if s < res[1]:
        res = [i, s]
print(res[0] + 1)