from typing import List
import sys

read = sys.stdin.readline

def sol(path: List[int] = []):
    if len(path) == m:
        res.append(path)
        return
    for x in range(1, n + 1):
        sol(path + [x])


n, m = map(int, read().split())
res = []
sol()
for r in res:
    print(*r)