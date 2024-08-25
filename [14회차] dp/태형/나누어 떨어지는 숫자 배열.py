def solution(arr, divisor):
    answer = []
    for x in arr:
        if not x % divisor:
            answer.append(x)
    return sorted(answer) if answer else [-1]