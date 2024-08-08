import sys
from itertools import combinations

read = sys.stdin.readline

def sol(poses):
    ret = []
    for dist in zip(*[stores[pos] for pos in poses]):
        ret.append(min(dist))
    return sum(ret)

def get_chicken_dist(chicken):
    x, y = chicken
    for k in range(len(houses)):
        stores[(x, y)].append(abs(x - houses[k][0]) + abs(y - houses[k][1]))

n, m = map(int, read().split())
graph = [list(map(int, read().split())) for _ in range(n)]
stores, houses = {}, []
res = sys.maxsize
for i in range(n):
    for j in range(n):
        if graph[i][j] == 2:
            stores[(i, j)] = []
        elif graph[i][j] == 1:
            houses.append((i, j))
for store in stores:
    get_chicken_dist(store)
for t in range(1, m + 1):
    for comb in combinations(stores.keys(), t):
        res = min(res, sol(comb))
print(res)
