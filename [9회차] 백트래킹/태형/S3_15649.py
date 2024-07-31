from typing import List

def sol(remainder: List[int], path: List[int]):
    if len(path) == m:
        res.append(path[:])
        return
    for x in remainder:
        next = remainder[:]
        next.remove(x)
        sol(next, path + [x])

n, m = map(int, input().split())
res = []
sol(list(range(1, n+1)), [])
for r in res:
    print(*r)