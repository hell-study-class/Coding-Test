import sys

sys.setrecursionlimit(int(1e6))

read = sys.stdin.readline

def dfs(start):
    global count
    visit[start-1] = 1
    for i in graph[start]:
        if not visit[i-1]:
            count += 1
            dfs(i)
    return count

num = int(read().rstrip())
arr = []
for _ in range(num):
    count = 0
    n, m = map(int, read().rstrip().split())

    visit = list(0 for _ in range(n))
    graph = {i: [] for i in range(1, n + 1)}

    for _ in range(m):
        s, e = map(int, read().rstrip().split())
        graph[s].append(e)
        graph[e].append(s)
    v=dfs(1)
    arr.append(v)
for i in arr:
    print(i)