import sys
read = sys.stdin.readline

n = int(read())
k = int(read())
road = list(map(int,read().split()))
road.sort()

var = []
for i in range(1,n):
    var.append(road[i] - road[i-1])
var.sort(reverse = True)
print(sum(var[k-1:]))