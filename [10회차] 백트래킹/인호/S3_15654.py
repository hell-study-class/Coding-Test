n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))
visited = [False for _ in range(n)]
line = []

def DFS(d):
    if d == m:
        for num in line:
            print(num,end=" ")
        print()
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            line.append(arr[i])
            DFS(d+1)
            visited[i] = False
            line.pop()

DFS(0)