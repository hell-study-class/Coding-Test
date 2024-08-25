from typing import List


def solution(m: int, n: int, puddles: List[List[int]]):
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    dp[1][1] = 1
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if [j, i] in puddles:
                continue
            if [j - 1, i] not in puddles:
                dp[i][j] += dp[i][j - 1]
            if [j, i - 1] not in puddles:
                dp[i][j] += dp[i - 1][j]
    return dp[n][m] % 1_000_000_007
