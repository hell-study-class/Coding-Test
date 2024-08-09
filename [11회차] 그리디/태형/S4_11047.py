n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
res = 0
for coin in coins[::-1]:
    m, k = divmod(k, coin)
    res += m
print(res)