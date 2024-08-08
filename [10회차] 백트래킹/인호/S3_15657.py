n,m = map(int,input().split())
line = sorted(list(map(int,input().split())))

arr = []

def dfs(d,idx):
    if d == m:
        for num in arr:
            print(num,end=" ")
        print()
        return
    for i in range(idx,n):
        arr.append(line[i])
        dfs(d+1,i)
        arr.pop()

dfs(0,0)