import sys
read = sys.stdin.readline
INF = int(1e9)
v, e = map(int, read().split())
graph = [[int(1e9)] * v for _ in range(v)]

for _ in range(e):
    a, b, c = map(int, read().split())
    a -= 1
    b -= 1
    graph[a][b] = c

for k in range(1, v):
    for i in range(v):
        for j in range(v):
            if graph[i][k] + graph[k][j] < graph[i][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

res = INF
for i in range(v):
    res = min(res, graph[i][i])

print(res if res != INF else -1)

'''
pypy 사용
python3 시간초과
'''