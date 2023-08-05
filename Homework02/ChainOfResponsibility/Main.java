package Homework02.ChainOfResponsibility;

// Шаблон "Цепочка ответственности" помогает избежать привязки отправителя запроса к его получателю,
// что дает возможность обработать данный запрос несколькими объектами.
// Это достигается путем создания цепочки объектов, каждый из которых может обрабатывать запрос,
// или передавать запрос по цепочке до тех пор, пока он не будет обработан.
// С данным шаблоном отправителю не нужно ничего знать о получателе.


public class Main {
    public static void main(String[] args) {
        MessageSender reportMessageSender = new LogReportMessageSender(PriorityLevel.LOW);
        MessageSender emailMessageSender = new EmailMessageSender(PriorityLevel.MIDDLE);
        MessageSender smsMessageSender = new SMSMessageSender(PriorityLevel.HIGH);

        reportMessageSender.setNextMessageSender(emailMessageSender);
        emailMessageSender.setNextMessageSender(smsMessageSender);

        reportMessageSender.messageSenderManager("Что-то происходит!", PriorityLevel.LOW);

        System.out.println("---------------------------------------------------------------------");
        reportMessageSender.messageSenderManager("Что-то пошло не так!", PriorityLevel.MIDDLE);

        System.out.println("---------------------------------------------------------------------");
        reportMessageSender.messageSenderManager("У нас возникла проблема!", PriorityLevel.HIGH);
    }
}



enum PriorityLevel {
    LOW, MIDDLE, HIGH
}

abstract class MessageSender {
    private PriorityLevel priorityLevel;
    private MessageSender nextMessageSender;

    public MessageSender(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public void setNextMessageSender(MessageSender nextMessageSender) {
        this.nextMessageSender = nextMessageSender;
    }

    public void messageSenderManager(String message, PriorityLevel level) {
        if (level.ordinal() >= priorityLevel.ordinal()) {
            write(message);
        }
        if (nextMessageSender != null) {
            nextMessageSender.messageSenderManager(message, level);
        }
    }

    public abstract void write(String message);
}

class LogReportMessageSender extends MessageSender{
    public LogReportMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    public void write(String message) {
        System.out.println("Отправитель сообщения, использующий простой отчет журнала: " + message);
    }
}

class EmailMessageSender extends MessageSender{
    public EmailMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    public void write(String message) {
        System.out.println("Отправка электронного письма: " + message);
    }
}

class SMSMessageSender extends MessageSender{
    public SMSMessageSender(PriorityLevel priorityLevel) {
        super(priorityLevel);
    }

    @Override
    public void write(String message) {
        System.out.println("Отправка SMS менеджеру: " + message);
    }
}