class Solution:
    def sol(self, a:int, b:int, n:int):
        if n == 1:
            res.append(str(a)+" "+str(b))
            return
        else:
            self.sol(a,6-a-b,n-1)
            res.append(str(a)+" "+str(b))
            self.sol(6-a-b,b,n-1)

res = []
n = int(input())
s = Solution()
s.sol(1,3,n)
print(len(res))
for r in res:
    print(r)