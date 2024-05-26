MOD = 10 ** 9 + 7


def sum_of_absolute_coordinates(D, R):
    from itertools import product

    # Generates all integer points in D-dimensional space within [-R, R]
    ranges = range(-R, R + 1)
    points = product(ranges, repeat=D)

    total_sum = 0

    for point in points:
        if sum(x * x for x in point) <= R * R:
            total_sum += sum(abs(x) for x in point)
            total_sum %= MOD

    return total_sum


# Input
D, R = map(int, input().split())

# Output the result
print(sum_of_absolute_coordinates(D, R))
