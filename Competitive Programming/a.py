from sys import stdout


def SieveOfSundaram(n):
    nNew = int((n - 1) / 2)
    marked = [False] * (nNew + 1)
    if n > 2:
        stdout.write("2\n")
    for i in range(1, nNew + 1):
        j = i
        while (i + j + 2 * i * j) <= nNew:
            marked[i + j + 2 * i * j] = True
            j += 1
        if not marked[i]:
            stdout.write(f"{2 * i + 1}\n")


n = 1000000000
SieveOfSundaram(n)