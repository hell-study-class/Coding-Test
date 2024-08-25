def solution(arr):
    res = [arr[0]]
    current = arr[0]
    for x in arr:
        if current != x:
            res.append(x)
            current = x
    return res
