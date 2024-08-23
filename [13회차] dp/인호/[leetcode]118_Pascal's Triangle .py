from typing import List
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(numRows):
            line = []
            if i == 0:
                res.append([1])
            else:
                for j in range(i+1):
                    if j == 0 or j == i:
                        line.append(1)
                    else:
                        line.append(res[i-1][j-1]+res[i-1][j])
                res.append(line)
        return res

