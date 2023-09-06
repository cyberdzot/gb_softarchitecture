import json
import requests

# Test POST request - create NEW book => TRUE = return json, where name is received_info and status code 201
# HEADERS = {'Authorization': 'APIKey my_gb_token'}
# JSON = {'id': '0', 'name': 'Война и мир', 'author': 'Толстой Л.Н.'}
# URL = requests.post(f"http://127.0.0.1:5000/books", headers=HEADERS, json=JSON)

# print(URL.json())

# Test GET request - get a list of all books json, where name is received_info and status code 201
# HEADERS = {'Authorization': 'APIKey my_gb_token'}
# URL = requests.get(f"http://127.0.0.1:5000/books", headers=HEADERS)
# if URL.status_code == 201:
#     print(URL.json())
# else:
#     print(URL.status_code)

# Test GET request - getting information about a book by id, where name is received_info and status code 201
# HEADERS = {'Authorization': 'APIKey my_gb_token'}
# PARAMS = {'id': '1'}
# URL = requests.get(f"http://127.0.0.1:5000/books", headers=HEADERS, params=PARAMS)

# if URL.status_code == 201:
#     print(URL.json())
# else:
#     print(URL.json())

# Test PUT request - putting information about a book by id, where name is received_info and status code 201
# HEADERS = {'Authorization': 'APIKey my_gb_token'}
# JSON = {'name': 'Мастер и Маргарита', 'author': 'Булгаков М.'}
# URL = requests.put(f"http://127.0.0.1:5000/books/1", headers=HEADERS, json=JSON)

# if URL.status_code == 201:
#     print(URL.json())
# else:
#     print(URL)

# Test DELETE request - deletting information about a book by id, where name is received_info and status code 201
# HEADERS = {'Authorization': 'ApiKey my_gb_token'}
# URL = requests.delete(f"http://127.0.0.1:5000/books/1", headers=HEADERS)

# if URL.status_code == 201:
#     print(URL.json())
# else:
#     print(URL)
