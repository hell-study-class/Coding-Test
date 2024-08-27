def solution(n, words):
    turn = 0
    used_words = set()
    last_word = words[0][0]
    for i in range(0, len(words), n):
        turn += 1
        for j, word in enumerate(words[i:i+n]):
            if word[0] != last_word or word in used_words:
                return [j+1, turn]
            used_words.add(word)
            last_word = word[-1]
    return [0, 0]