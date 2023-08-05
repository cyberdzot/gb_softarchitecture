package Homework02.Mediator;

import java.util.ArrayList;
import java.util.List;

// Шаблон проектирования посредник используется для обеспечения централизованной среды связи между различными объектами в системе.
// Шаблон проектирования посредника очень полезен в корпоративном приложении, где несколько объектов взаимодействуют друг с другом.
// Если объекты взаимодействуют друг с другом напрямую, компоненты системы тесно связаны друг с другом,
// что повышает стоимость обслуживания и не позволяет легко расширяться.
// Шаблон посредника фокусируется на предоставлении посредника между объектами для связи и помощи в реализации потери связи между объектами.

public class Main {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new UserImpl(mediator, "Паша");
        User user2 = new UserImpl(mediator, "Саша");
        User user3 = new UserImpl(mediator, "Даша");
        User user4 = new UserImpl(mediator, "Яша");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Олды здесь?");
    }
}

interface ChatMediator {
    public void sendMessage(String msg, User user);
    void addUser(User user);
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}

class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            // сообщение не должно быть получено отправляющим его пользователем
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}

class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + ": Отправка сообщения: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + ": Получено сообщение: " + msg);
    }
}