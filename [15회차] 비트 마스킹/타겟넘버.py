def solution(numbers, target):
    def dfs(s, depth=1):
        nonlocal res
        if depth == len(numbers):
            if s == target:
                res += 1
            return
        dfs(s + numbers[depth], depth + 1)
        dfs(s - numbers[depth], depth + 1)
    res = 0
    dfs(numbers[0])
    dfs(-numbers[0])
    return res