L,C = map(int,input().split())
line = sorted(list(map(str,input().split())))

visited = [False] * C

arr= []

def dfs(d,g,cons,idx):
    if d == L and g > 0 and cons > 1:
        for st in arr:
            print(st,end="")
        print()
        return
    for i in range(idx,C):
        if not visited[i]:
            visited[i] = True
            arr.append(line[i])
            if line[i] in ['a','e','i','o','u']:
                g+=1
            else:
                cons+=1
            dfs(d+1,g,cons,i+1)
            visited[i] = False
            p = arr.pop()
            if line[i] in ['a','e','i','o','u']:
                g-=1
            else:
                cons-=1

dfs(0,0,0,0)