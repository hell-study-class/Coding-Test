h, w = map(int, input().split())
heights = list(map(int, input().split()))
res = 0

for i in range(1, w - 1):
    left, right = 0, 0
    for j in range(i):
        if heights[j] > left:
            left = heights[j]
    for j in range(i + 1, w):
        if heights[j] > right:
            right = heights[j]
    res += max(0, min(left, right) - heights[i])
print(res)

'''
하나씩 순회하면서 왼쪽과 오른쪽 각각의 최댓값을 구하고, 둘 중의 최솟값과의 차이만큼 결과에 더함
'''