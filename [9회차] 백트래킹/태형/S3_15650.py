import sys
from typing import List

sys.setrecursionlimit(int(1e9))


def sol(i: int = 0, path: List[int] = []):
    if len(path) == m:
        res.append(path)
        return
    for j in range(i + 1, n + 1):
        sol(j, path + [j])

n, m = map(int, input().split())
res = []
sol()
for r in res:
    print(*r)