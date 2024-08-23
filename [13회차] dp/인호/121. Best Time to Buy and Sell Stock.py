from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_price = int(1e5)
        for price in prices:
            if price < min_price:
                min_price = price
            else:
                profit = max(profit,price-min_price)
        return profit
s = Solution()
print(s.maxProfit(map(int,input().strip('[]').split(','))))