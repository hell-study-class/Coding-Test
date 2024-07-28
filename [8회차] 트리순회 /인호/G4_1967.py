import sys

sys.setrecursionlimit(int(1e6))
read = sys.stdin.readline

n = int(read().strip())
tree = [[] for _ in range(n + 1)]

for _ in range(n-1):
    p, c, l = map(int, read().rstrip().split())
    tree[p].append([c,l])
    tree[c].append([p,l])
def dfs(s,length,visited):
    if length > maximum[1]:
        maximum[1] = length
        maximum[0] = s
    visited[s] = True
    for node in tree[s]:
        if not visited[node[0]]:
            dfs(node[0],length+node[1],visited)



maximum =[0,0]
visited = [False] * (n+1)
dfs(1,0,visited)

new_start = maximum[0]
maximum =[0,0]
visited = [False] * (n+1)
dfs(new_start,0,visited)
print(maximum[1])