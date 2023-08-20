package Homework06.boundary;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        // Добавляем книги в магазин
        Book book1 = new Book("1", "Clean Code", "Robert C. Martin", 34.99);
        Book book2 = new Book("2", "Effective Java", "Joshua Bloch", 29.99);
        bookStore.addBook(book1);
        bookStore.addBook(book2);

        // Получаем список всех книг в магазине
        List<Book> allBooks = bookStore.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("Книга: " + book.getTitle() + ", Автор: " + book.getAuthor() + ", Цена: $" + book.getPrice());
        }
    }
}


// Класс представляющий книгу
class Book {
    private String id;
    private String title;
    private String author;
    private double price;

    // Конструктор, геттеры и сеттеры
    public Book(String string, String string2, String string3, double d) {
        // 
    }
}

// Класс, реализующий хранилище книг с использованием коллекций
class BookStore {
    private List<Book> books;

    public BookStore() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }
}