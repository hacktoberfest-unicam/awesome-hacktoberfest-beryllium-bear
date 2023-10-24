from flask import Flask, request, jsonify
import json

app = Flask(__name__)

def custom_sort(item):
    if isinstance(item, str):
        return (0, item)
    if isinstance(item, int):
        return (1, item)

@app.route('/sort', methods=['POST'])
def sort_array():
    try:
        data = request.json
        if not data or 'array' not in data:
            return jsonify({'error': 'Invalid input. Provide an array in JSON format.'}), 400

        array = data['array']
        sorted_array = sorted(array, key=custom_sort)

        return jsonify({'sorted_array': sorted_array})

    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
