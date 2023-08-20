package Homework06.control;

import Homework06.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс BookStore представляет реализацию интерфейса IBookStore,
 * использующий 'коллекцию' для хранения книг.
 */
public class BookStore implements IBookStore {
    private List<Book> books;

    /**
     * Создает новый экземпляр класса BookStore.
     */
    public BookStore() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
