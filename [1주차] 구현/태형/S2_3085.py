import sys
from typing import List
from itertools import groupby

read = sys.stdin.readline


def get_longest_length(L: List[int]):
    return max([len(list(g)) for _, g in groupby(L)])


def swap_and_check_row(r_idx1: int, r_idx2: int, c_idx: int):
    graph[r_idx1][c_idx], graph[r_idx2][c_idx] = graph[r_idx2][c_idx], graph[r_idx1][c_idx]
    ret = max(max(get_longest_length(graph[r_idx1]), get_longest_length(graph[r_idx2])),
              get_longest_length([graph[idx][c_idx] for idx in range(n)]))
    graph[r_idx1][c_idx], graph[r_idx2][c_idx] = graph[r_idx2][c_idx], graph[r_idx1][c_idx]
    return ret


def swap_and_check_col(c_idx1: int, c_idx2: int, r_idx: int):
    graph[r_idx][c_idx1], graph[r_idx][c_idx2] = graph[r_idx][c_idx2], graph[r_idx][c_idx1]
    ret = max(max(get_longest_length([graph[idx][c_idx1] for idx in range(n)]),
              get_longest_length([graph[idx][c_idx2] for idx in range(n)])),
              get_longest_length(graph[r_idx]))
    graph[r_idx][c_idx1], graph[r_idx][c_idx2] = graph[r_idx][c_idx2], graph[r_idx][c_idx1]
    return ret


n = int(read())
graph = [list(map(lambda x: {'C': 1, 'P': 2, 'Z': 3, 'Y': 4}[x],
                  list(read().rstrip()))) for _ in range(n)]
res = 0

for i in range(n):
    res = max(res, get_longest_length(graph[i]))
    res = max(res, get_longest_length([graph[r_idx][i] for r_idx in range(n)]))

for i in range(n):
    for j in range(n - 1):
        res = max(res, swap_and_check_col(j, j+1, i))

for j in range(n):
    for i in range(n - 1):
        res = max(res, swap_and_check_row(i, i+1, j))
print(res)
