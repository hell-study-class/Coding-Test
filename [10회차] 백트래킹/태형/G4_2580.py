import sys

sys.setrecursionlimit(int(1e9))

def get_block(i: int, j: int):
    return (i // 3) * 3 + (j // 3)

def sol(idx: int = 0):
    if idx == len(blanks):
        for row in graph:
            print(*row)
        exit(0)

    x, y = blanks[idx]
    block = get_block(x, y)
    for num in range(1, 10):
        if not row_visited[x][num] and not col_visited[y][num] and not block_visited[block][num]:
            row_visited[x][num] = True
            col_visited[y][num] = True
            block_visited[block][num] = True
            graph[x][y] = num
            sol(idx + 1)
            row_visited[x][num] = False
            col_visited[y][num] = False
            block_visited[block][num] = False
            graph[x][y] = 0


graph = [list(map(int, input().split())) for _ in range(9)]
row_visited = [[False] * 10 for _ in range(9)]
col_visited = [[False] * 10 for _ in range(9)]
block_visited = [[False] * 10 for _ in range(9)]
blanks = []
res = None

for i in range(9):
    for j in range(9):
        if not graph[i][j]:
            blanks.append((i, j))
        else:
            row_visited[i][graph[i][j]] = True
            col_visited[j][graph[i][j]] = True
            block_visited[get_block(i, j)][graph[i][j]] = True
sol()