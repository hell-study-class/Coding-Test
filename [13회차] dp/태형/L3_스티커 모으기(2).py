from typing import List


def solution(ss: List[int]):
    if len(ss) == 1:
        return ss[0]
    else:
        dp = [[0, 0] for _ in range(100_000)]
        dp[0][0], dp[1][0] = ss[0], ss[0]
        dp[0][1], dp[1][1] = 0, ss[1]
        for i in range(2, len(ss)):
            for j in range(2):
                dp[i][j] = max(dp[i-1][j], ss[i] + dp[i-2][j])
        return max(dp[len(ss)-1][1], dp[len(ss)-2][0])