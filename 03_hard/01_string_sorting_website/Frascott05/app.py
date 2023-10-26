from flask import Flask, request, jsonify

app = Flask(__name__)

def bubble_sort(arr, ascending=True):
    n = len(arr)
    for i in range(n - 1):
        for j in range(0, n - i - 1):
            if (ascending and arr[j] > arr[j + 1]) or (not ascending and arr[j] < arr[j + 1]):
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

def insertion_sort(arr, ascending=True):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and ((ascending and key < arr[j]) or (not ascending and key > arr[j])):
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

@app.route('/api/sort', methods=['GET'])
def sort_array():
    print("test")
    try:
        data = request.args.get("array")

        print(data)
        input_array = data['array']
        sort_algorithm = data['algorithm']
        ascending_order = data['ascending']

        if sort_algorithm == 'bubbleSort':
            bubble_sort(input_array, ascending_order)
        elif sort_algorithm == 'insertionSort':
            insertion_sort(input_array, ascending_order)

        response_data = {'sorted_array': input_array}
        print(response_data)
        return jsonify(response_data)

    except Exception as e:
        return jsonify(error=str(e)), 400

if __name__ == '__main__':
    app.run(debug=True)

