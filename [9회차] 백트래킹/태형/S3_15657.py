from typing import List

def sol(i: int, path: List[int] = []):
    if len(path) == m:
        res.append(path)
        return
    for j in range(i, n):
        sol(j, path + [nums[j]])

n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
res = []
sol(0)
for r in res:
    print(*r)