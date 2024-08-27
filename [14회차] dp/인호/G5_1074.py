class Solution:
    def sol(self, n:int, r:int, c:int):
        if n == 0 : return 0
        half = 2**(n-1)
        if r < half and c < half: return self.sol(n-1,r,c)
        elif r < half and c >= half: return half*half + self.sol(n-1,r,c-half)
        elif r >= half and c < half: return 2*half*half + self.sol(n-1,r-half,c)
        else: return 3*half*half + self.sol(n-1,r-half, c-half)

s = Solution()
n,r,c = map(int, input().split())
print(s.sol(n,r,c))

