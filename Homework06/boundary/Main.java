package Homework06.boundary;

import Homework06.entity.Book;
import Homework06.control.BookStore;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Регистрируем книжный магазин
        BookStore bookStore = new BookStore();

        // Создаём книги
        Book book1 = new Book(1, "Clean Code", "Robert C. Martin", 34.99);
        Book book2 = new Book(2, "Effective Java", "Joshua Bloch", 29.99);

        // Добавляем книги в магазин
        bookStore.addBook(book1);
        bookStore.addBook(book2);

        // Получаем список всех книг в магазине
        List<Book> allBooks = bookStore.getAllBooks();
        for (Book book : allBooks) {
            System.out.println(
                    "Книга: " + book.getTitle() + ", Автор: " + book.getAuthor() + ", Цена: $" + book.getPrice());
        }
    }
}