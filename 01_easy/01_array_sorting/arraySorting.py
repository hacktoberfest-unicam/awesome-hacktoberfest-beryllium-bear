def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        # Flag to optimize if the inner loop makes no swaps, the list is already sorted
        swapped = False

        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                # Swap the elements if they are in the wrong order
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True

        # If no two elements were swapped in the inner loop, the list is already sorted
        if not swapped:
            break

# Example usage
if __name__ == "__main__":
    numbers = [64, 34, 25, 12, 22, 11, 90]
    print("Original List:", numbers)

    bubble_sort(numbers)

    print("Sorted List:", numbers)
