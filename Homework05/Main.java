package Homework05;

import java.util.ArrayList;
import java.util.List;

/**
 * Сущность пользователя
 */
class User {
    private String name;
    private String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }
}

/**
 * Класс для работы User с БД
 */
class DB {
    private List<User> users;

    public DB() {
        this.users = new ArrayList<>();
    }

    // Метод для добавления пользователя в базу данных
    public void add(User user) {
        users.add(user);
        System.out.println("Пользователь '" + user.getName() + "' добавлен в базу данных.");
    }

    // Метод для обновления пользователя в базе данных
    public void update(User user) {
        for (User u : users) {
            if (u.getName().equals(user.getName())) {
                u.setPassword(user.getPassword());
                System.out.println("Пользователь '" + user.getName() + "' обновлён в базе данных.");
                return;
            }
        }
        System.out.println("Пользователь '" + user.getName() + "' не найден в базе данных.");
    }

    // Метод для удаления пользователя из базы данных
    public void delete(User user) {
        if (users.remove(user)) {
            System.out.println("Пользователь '" + user.getName() + "' удалён из базы данных.");
        } else {
            System.out.println("Пользователь '" + user.getName() + "' не найден в базе данных.");
        }
    }

    // Метод для поиска пользователя в базе данных
    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        User user1 = new User("Vova", "123");
        User user2 = new User("Sasha", "456");

        db.add(user1);
        db.add(user2);

        User foundUser1 = db.findByName("Vova");
        System.out.println("Найден пользователь: '" + foundUser1.getName() + "' / пароль: " + foundUser1.getPassword() + ".");

        User foundUser2 = db.findByName("Yasha");
        System.out.println(
                foundUser2 != null
                        ? "Найден пользователь: '" + foundUser2.getName() + "' / пароль: " + foundUser1.getPassword() + "."
                        : "Пользователь не найден!");

        user1.setPassword("789");
        db.update(user1);
        System.out.println("Найден пользователь: '" + foundUser1.getName() + "' / пароль: " + foundUser1.getPassword() + ".");

        db.delete(user2);
    }
}
