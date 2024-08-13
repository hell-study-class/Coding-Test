class Solution:
    def climbStairs(self, s: int) -> int:
        if s == 1:
            return 1
        elif s == 2:
            return 2
        else:
            memo = [0,1,2]
            for i in range(3,s + 1):
                memo.append(memo[i - 1] + memo[i - 2])
            return memo[-1]