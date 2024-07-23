import sys
from collections import deque

def dfs(start):
    dfsVisit[start] = 1
    print(start, end=" ")
    for j in graph[start]:
        if not dfsVisit[j]:
            dfs(j)


def bfs(start):
    bfsVisit[start] = 1
    que = deque([start])
    while que:
        v = que.popleft()
        print(v, end = " ")
        for i in graph[v]:
            if not bfsVisit[i]:
                bfsVisit[i] = 1
                que.append(i)

read = sys.stdin.readline

n,m,k = map(int, read().rstrip().split())
graph = {i: [] for i in range(1, n+1)}
dfsVisit =list(0 for _ in range(n+1))
bfsVisit =list(0 for _ in range(n+1))

for _ in range(m):
    s,e = map(int, read().rstrip().split())
    graph[s].append(e)
    graph[e].append(s)

for i in graph:
    graph[i].sort()

dfs(k)
print()
bfs(k)