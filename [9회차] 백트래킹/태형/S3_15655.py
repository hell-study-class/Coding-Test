def sol(i: int = 0, path=[]):
    if len(path) == m:
        res.append(path)
        return
    for j in range(i, n):
        sol(j + 1, path + [nums[j]])

n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
res = []
sol()
for r in res:
    print(*r)