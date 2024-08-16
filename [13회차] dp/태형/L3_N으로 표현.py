def solution(N: int, number: int):
    answer = -1
    dp = [set() for _ in range(9)]
    for i in range(1, 9):
        dp[i].add(int(str(N) * i))
        for j in range(i):
            for x in dp[j]:
                for y in dp[i-j]:
                    dp[i].add(x + y)
                    dp[i].add(x - y)
                    dp[i].add(x * y)
                    if y: dp[i].add(x // y)
        if number in dp[i]:
            answer = i
            break
    return answer