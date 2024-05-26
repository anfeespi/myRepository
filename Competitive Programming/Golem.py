import math
from collections import defaultdict


def gcd(a, b):
    return math.gcd(a, b)


def max_team_strength(n, heights):
    # Step 1: Frequency count of each height
    freq = [0] * 21
    for height in heights:
        freq[height] += 1

    # Step 2: Precompute GCD values for range 1 to 20
    gcd_values = [[0] * 21 for _ in range(21)]
    for i in range(1, 21):
        for j in range(1, 21):
            gcd_values[i][j] = gcd(i, j)

    max_strength = 0

    # Step 3: Dynamic Programming to find the best possible strength
    for captain in range(1, 21):
        if freq[captain] == 0:
            continue
        strength = 0
        for robot in range(1, 21):
            if robot != captain and freq[robot] > 0:
                strength += freq[robot] * gcd_values[captain][robot]
        max_strength = max(max_strength, strength)

    return max_strength


# Input reading
n = int(input().strip())
heights = list(map(int, input().strip().split()))

# Compute the result
result = max_team_strength(n, heights)

# Output the result
print(result)
