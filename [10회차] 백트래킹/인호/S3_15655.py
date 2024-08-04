n,m = map(int, input().split())
arr = sorted(list(map(int,input().split())))
line = []
visited = [False for _ in range(n)]

def DFS(d,idx):
    if d == m:
        for num in line:
            print(num,end=" ")
        print()
        return
    for i in range(idx,n):
        if not visited[i]:
            visited[i] = True
            line.append(arr[i])
            DFS(d+1,i+1)
            visited[i] = False
            line.pop()
DFS(0,0)