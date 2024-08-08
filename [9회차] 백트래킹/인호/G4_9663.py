n = int(input())
cnt = 0
row = [0] * n

def is_promise(x):
    for i in range(x):
        if row[i] == row[x] or abs(row[i] - row[x]) == abs(i -x):
            return False
    return True

def dfs(x):
    global cnt
    if x == n:
        cnt+=1
        return
    else:
        for i in range(n):
            row[x] = i
            if is_promise(x):
                dfs(x+1)
dfs(0)
print(cnt)