import sys

read = sys.stdin.readline
INF = int(1e6)


def check(i):
    l1 = graph[i]
    l2 = [graph[j][i] for j in range(n)]
    for x in range(n):
        if min(l1[x], l2[x]) == INF:
            return False
    return True


n, m = map(int, read().split())
graph = [[INF] * n for _ in range(n)]
res = 0

for _ in range(m):
    a, b = map(lambda x: x - 1, map(int, read().split()))
    graph[a][b] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
for i in range(n):
    graph[i][i] = 0

for i in range(n):
    if check(i):
        res += 1
print(res)