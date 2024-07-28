import sys
from typing import Set

read = sys.stdin.readline
sys.setrecursionlimit(int(1e9))


def dfs(v: int, visited: Set[int], cur: int = 0, res: int = 0):
    visited.add(v)
    if cur > res:
        global node
        node, res = v, cur
    for w in graph[v]:
        if w[0] not in visited:
            res = dfs(w[0], visited, cur + w[1], res)
    return res


n = int(read())
graph = {i: [] for i in range(1, n + 1)}
f_visited, s_visited = set(), set()
node = None

if n == 1:
    print(0)
else:
    for _ in range(n - 1):
        s, e, v = map(int, read().split())
        graph[s].append((e, v))
        graph[e].append((s, v))
    start_v = list(graph.keys())[0]
    dfs(start_v, f_visited)
    print(dfs(node, s_visited))