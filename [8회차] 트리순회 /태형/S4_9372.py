import sys

read = sys.stdin.readline
sys.setrecursionlimit(int(1e9))


def sol(v, ret):
    visited[v] = True
    for w in graph[v]:
        if not visited[w]:
            ret = sol(w, ret + 1)
    return ret

res = []
for T in range(int(read())):
    n, m = map(int, read().split())
    visited = [False] * (n + 1)
    graph = {i: [] for i in range(n + 1)}

    for _ in range(m):
        a, b = map(int, read().split())
        graph[a].append(b)
        graph[b].append(a)
    res.append(str(sol(1, 0)))
print('\n'.join(res))