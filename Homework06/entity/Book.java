package Homework06.entity;

/**
 * Сущность - "Книга".
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    /**
     * Создает новый экземпляр сущности "Книга".
     *
     * @param id     идентификатор книги.
     * @param title  название книги.
     * @param author автор книги.
     * @param price  цена книги.
     */
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Геттеры и сеттеры
    /**
     * Метод получения ID книги в коллекции.
     *
     * @return идентификатор книги.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод получения названия книги.
     *
     * @return название книги.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод получения автора книги.
     *
     * @return автор книги.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Метод получения цены книги.
     *
     * @return цена книги.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Метод установки цены для книги.
     *
     * @param price цена
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
