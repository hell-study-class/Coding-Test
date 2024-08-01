import sys
from typing import List

read = sys.stdin.readline


def sol(remainder: List[int], path: List[int] = []):
    if len(path) == 6:
        res.append(path)
        return
    for i in range(len(remainder)):
        sol(remainder[i+1:], path + [remainder[i]])


while True:
    inputs = list(map(int, read().split()))
    k = inputs[0]
    if not k:
        break
    res = []
    sol(inputs[1:])
    for r in res:
        print(*r)
    print()
