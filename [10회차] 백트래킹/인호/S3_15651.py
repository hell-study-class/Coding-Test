n,m = map(int,input().split())

arr = []

def DFS(d):
    if d == m:
        for num in arr:
            print(num,end=" ")
        print()
        return
    for i in range(1, n+1):
        arr.append(i)
        DFS(d+1)
        arr.pop()

DFS(0)

