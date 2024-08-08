from typing import List


def sol(remainder: List[int], path: List[int] = []):
    if not remainder:
        res.append(path)
        return
    for num in remainder:
        next = remainder[:]
        next.remove(num)
        sol(next, path + [num])

n = int(input())
res = []
sol(list(range(1, n + 1)))
for r in res:
    print(*r)