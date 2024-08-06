n,m = map(int,input().split())

arr = []
def DFS(d,idx):
    if d == m:
        for num in arr:
            print(num,end = " ")
        print()
        return
    for i in range(idx,n+1):
        arr.append(i)
        DFS(d+1,i)
        arr.pop()
DFS(0,1)