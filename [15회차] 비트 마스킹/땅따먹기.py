from typing import List


def solution(land: List[List[int]]):
    dp = [[0] * 4 for _ in range(len(land))]
    dp[0] = land[0]
    for i in range(1, len(land)):
        for j in range(4):
            dp[i][j] = land[i][j] + max(dp[i - 1][k] for k in range(4)
                                        if k != j)
    return max(dp[-1])
