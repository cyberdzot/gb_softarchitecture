package Homework06.control;

import java.util.List;

import Homework06.entity.Book;

/**
 * Интерфейс IBookStore определяет методы для управления книгами в коллекции.
 */
public interface IBookStore {
    /**
     * Метод добавления книги в коллекцию.
     *
     * @param book экземпляр книги для добавления.
     */
    void addBook(Book book);

    /**
     * Метод удаления книги из коллекции.
     *
     * @param book экземпляр книги для удаления.
     */
    void removeBook(Book book);

    /**
     * Метод получения всех книг из коллекции.
     *
     * @return список всех книг.
     */
    List<Book> getAllBooks();
}
