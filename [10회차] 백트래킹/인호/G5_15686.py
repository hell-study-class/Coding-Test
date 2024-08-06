import sys

read = sys.stdin.readline

n,m = map(int,read().split())
chicken_map = [[line for line in list(map(int,read().split()))] for _ in range(n)]
chicken = []
minn = 9999
directions = [(1,0),(-1,0),(0,1),(0,-1)]

for i in range(n):
    for j in range(n):
        if chicken_map[i][j] == 2:
            chicken.append((i,j))
            chicken_map[i][j] = 0

live = [False for _ in range(len(chicken))]
alive_chicken = []
def live_chicken(idx,chick):
    c = chick.copy()
    if len(chick) == m:
        alive_chicken.append(c)
        return
    for i in range(idx,len(chicken)):
        if not live[i]:
            live[i] = True
            chick.append(chicken[i])
            live_chicken(i+1,chick)
            live[i] = False
            chick.pop()

def cal(ac):
    total=0
    for i in range(n):
        for j in range(n):
            if chicken_map[i][j] == 1:
                mn = 999
                for c in ac:
                    mn = min(mn,(abs(i-c[0])+abs(j-c[1])))
                total+=mn
    return total

def sol():
    global minn
    for c in alive_chicken:
        minn = min(minn,cal(c))
    print(minn)
live_chicken(0,[])
sol()