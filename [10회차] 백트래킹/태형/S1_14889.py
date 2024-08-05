import sys
from itertools import combinations
from typing import Iterable

read = sys.stdin.readline


def get_score(nums: Iterable[int]):
    ret = 0
    for i in nums:
        for j in nums:
            ret += scores[i][j]
    return ret


n = int(read())
scores = [list(map(int, read().split())) for _ in range(n)]
people = set(range(n))
res = sys.maxsize

for comb in combinations(people, len(people) // 2):
    A, B = comb, people.difference(comb)
    res = min(res, abs(get_score(A) - get_score(B)))
print(res)
