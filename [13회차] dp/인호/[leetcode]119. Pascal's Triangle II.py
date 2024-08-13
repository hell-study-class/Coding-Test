from typing import List

class Solution:
    def getRow(self, rowIndex:int) -> List:
        line = [1] * (rowIndex+1)
        for i in range(1,rowIndex):
            for j in range(i,0,-1):
                line[j] = line[j-1]+line[j]
        return line
s = Solution()
print(s.getRow(3))