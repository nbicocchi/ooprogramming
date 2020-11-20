import timeit

def change_list(numbers):
    """This changes a passed list into this function"""
    numbers = [40, 50, 60]
    return


if __name__ == '__main__':
    squares = {1: 1, 3: 9, 5: 25, 7: 49, 9: 81}

    # membership tests for key only
    print(1 in squares)
    print(2 not in squares)
    print(49 in squares)

    # Iterating through keys
    for i in squares:
        print(squares[i])

    # Iterating through keys and values
    for k, v in squares.items():
        print(k, v)










