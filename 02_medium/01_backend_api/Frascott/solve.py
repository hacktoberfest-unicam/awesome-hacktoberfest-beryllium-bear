from flask import Flask, request, jsonify

app = Flask(__name__)


def custom_sort(arr):
    return sorted(arr, key=lambda x: (isinstance(x, int), x))


@app.route('/sort', methods=['POST'])
def sort_array():
    try:
        data = request.get_json()
        if not isinstance(data, list):
            return jsonify({"errore": "Devi inviare una lista!!!"}), 400

        sorted_data = custom_sort(data)
        return jsonify({"array_sistemato": sorted_data}), 200
    except Exception as e:
        return jsonify({"errore": "c'è stato un errore", "dettagli": str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
