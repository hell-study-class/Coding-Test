class Solution:
    def solution(self, a:int, b:int, c:int):
        if b == 1:
            return a%c
        else:
            if not b%2:
                return ((self.solution(a,b//2,c))**2)%c
            else:
                return ((self.solution(a,b//2,c))**2)*a%c

a,b,c = map(int,input().split())
s= Solution()
print(s.solution(a,b,c))
