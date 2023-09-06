from flask import Flask, jsonify, abort, request, make_response
from flask_httpauth import HTTPTokenAuth
import locale
locale.setlocale(
    category=locale.LC_ALL,
    locale="Russian")

app = Flask(__name__)
auth = HTTPTokenAuth(scheme='APIKey')

books = [
    {
        'id': '0',
        'name': 'Война и мир',
        'author': 'Толстой Л.Н.'
    },
    {
        'id': '1',
        'name': 'Сияние',
        'author': 'Кинг С.'
    },
    {
        'id': '2',
        'name': 'Гиперион',
        'author': 'Симмонс Д.'
    }
]


@auth.verify_token
def verify_token(token):
    if token == 'my_gb_token':
        return True
    return None


@auth.error_handler
def unauthorized():
    return make_response(jsonify({'error': 'Unauthorized access'}), 403)


@app.errorhandler(400)
def bad_request(error):
    return make_response(jsonify({'error': 'Bad request'}), 400)


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/books', methods=['GET', 'POST'])
@auth.login_required
def books_req():
    if request.method == 'POST':
        if not request.json \
                or not 'id' in request.json \
                or not 'name' in request.json \
                or not 'author' in request.json:
            abort(400)
        book = {
            'id': request.json['id'],
            'name': request.json['name'],
            'author': request.json['author']
        }
        create_book_task(book)
        return jsonify({'received_info': book}), 201
    elif request.method == 'GET':
        params = request.args.get('id')
        if params is None:
            return jsonify({'received_info': books}), 201
        else:
            for search_info in books:
                if search_info['id'] == params:
                    return jsonify({'received_info': search_info}), 201
                    break
            if search_info['id'] != params:
                return jsonify({'error': 'Not found'}), 404


def create_book_task(book_info):
    print(f'Получена информация о новой книге:\n'
          f'id: {book_info["id"]}\n'
          f'name: {book_info["name"]}\n'
          f'author: {book_info["author"]}')


@app.route('/books/<int:book_id>', methods=['PUT', 'DELETE'])
@auth.login_required
def update_books(book_id):
    if request.method == 'PUT':
        book = list(filter(lambda b: b['id'] == str(book_id), books))
        if len(book) == 0:
            abort(404)
        if not request.json \
                or not 'name' in request.json and type(request.json['name']) != str\
                or not 'author' in request.json and type(request.json['author']) != str:
            abort(400)
        book[0]['name'] = request.json.get('name', book[0]['name'])
        book[0]['author'] = request.json.get('author', book[0]['author'])
        return jsonify({'received_info': book[0]}), 201
    elif request.method == 'DELETE':
        book = list(filter(lambda b: b['id'] == str(book_id), books))
        if len(book) == 0:
            abort(404)
        books.remove(book[0])
        return jsonify({'received_info': True}), 201


if __name__ == '__main__':
    app.run(host="127.0.0.1", port=5000, debug=False)
