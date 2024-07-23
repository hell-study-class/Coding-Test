import sys

sys.setrecursionlimit(int(1e6))
read = sys.stdin.readline

def find(graph, vertex, visit):
    for i in graph[vertex]:
        if not visit[i]:
            visit[i] = vertex
            find(graph, i, visit)

n = int(read().rstrip())

tree = [[] for _ in range(n+1)]
parent = [None for _ in range(n+1)]

for _ in range(n-1):
    s,e = map(int, read().rstrip().split())
    tree[s].append(e)
    tree[e].append(s)

find(tree, 1, parent)

for i in range(2,n+1):
    print(parent[i])