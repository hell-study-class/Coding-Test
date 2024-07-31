from typing import List

def sol(i: int = 1, path: List[int] = []):
    if len(path) == m:
        res.append(path)
        return
    for j in range(i, n + 1):
        sol(j, path + [j])

n, m = map(int, input().split())
res = []
sol()
for r in res:
    print(*r)