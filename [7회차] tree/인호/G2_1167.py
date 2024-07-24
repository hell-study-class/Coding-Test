import sys

sys.setrecursionlimit(int(1e6))
read = sys.stdin.readline

n = int(read().rstrip())
tree = list([] for _ in range(n+1))

for _ in range(n):
    line = list(map(int,read().rstrip().split()))
    node = line[0]
    idx = 1
    while line[idx] != -1:
        tree[node].append((line[idx],line[idx+1]))
        idx+=2

visited = [-1] * (n+1)
visited[1] = 0

def dfs(node, dist):
    for n,d in tree[node]:
        cal_dist = dist + d
        if visited[n] ==-1:
            visited[n] = cal_dist
            dfs(n,cal_dist)

dfs(1,0)
tmp=[0,0]
for i in range(1, len(visited)):
    adj_n, adj_d = i, visited[i]
    if tmp[1] < adj_d:
        tmp[1] = adj_d
        tmp[0] = adj_n

visited = [-1] * (n+1)
visited[tmp[0]] = 0
dfs(tmp[0],0)

print(max(visited))

