import requests

data = [5, "ciao", 3, "come", 1, "va"]
response = requests.post('http://localhost:5000/sort', json=data)

if response.status_code == 200:
    sorted_data = response.json()["array_sistemato"]
    print(sorted_data)
else:
    print(f"Errore: {response.json()}")
