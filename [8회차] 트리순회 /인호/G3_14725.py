import sys

read = sys.stdin.readline

n = int(read().rstrip())
tree = []

for _ in range(n):
    line = read().rstrip().split()
    k = int(line.pop(0))-1
    tree.append(line)

tree.sort()

idx=0
dash = "--"
ptr =[]
for i in range(len(tree)):
    if i==0:
        ptr.append([])
        for j in range(len(tree[i])):
            ptr[idx].append(dash*j+tree[i][j])
    else:
        if tree[i-1][0] == tree[i][0]:
            k =0
            for f in range(len(tree[i-1])):
                if tree[i-1][f] == tree[i][f]:
                    k +=1
                else:
                    break
            for r in range(k,len(tree[i])):
                ptr[idx].append(dash*r+tree[i][r])
        else:
            idx+=1
            ptr.append([])
            for j in range(len(tree[i])):
                ptr[idx].append(dash*j+tree[i][j])

for line in ptr:
    for food in line:
        print(food)