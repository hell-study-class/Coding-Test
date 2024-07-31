from typing import List
import sys

read = sys.stdin.readline

def sol(remainder: List[int], path: List[int] = []):
    if len(path) == m:
        res.append(path)
        return
    for num in remainder:
        next = remainder[:]
        next.remove(num)
        sol(next, path + [num])

n, m = map(int, read().split())
nums = sorted(list(map(int, read().split())))
res = []
sol(nums)
for r in res:
    print(*r)