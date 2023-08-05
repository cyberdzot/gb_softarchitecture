package Homework02.Command;

// Command - это создание структуры, в которой класс-отправитель и класс-получатель не зависят друг от друга напрямую.
// Организация обратного вызова к классу, который включает в себя класс-отправитель.

public class Main {
    public static void main(String[] args) {
        // создаем объект, который будет использоваться
        Light l = new Light();

        // создаем объекты для всех умений объекта Light:
        Command switchUp = new TurnOnLightCommand(l);
        Command switchDown = new TurnOffLightCommand(l);

        // Создаемтся invoker, с которым мы будем непосредственно контактировать:
        Switch s = new Switch(switchUp, switchDown);

        // вот проверка этого, используем методы:
        s.flipUp();
        s.flipDown();
    }
}



class Light {
    public Light() {
        // 
    }

    public void turnOn() {
        System.out.println("Свет включен");
    }

    public void turnOff() {
        System.out.println("Свет выключен");
    }
}

interface Command {
    void execute();
}

class TurnOnLightCommand implements Command {
    private Light theLight;

    public TurnOnLightCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light theLight;

    public TurnOffLightCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOff();
    }
}

class Switch {
    private Command flipUpCommand;
    private Command flipDownCommand;

    public Switch(Command flipUpCommand, Command flipDownCommand) {
        this.flipUpCommand = flipUpCommand;
        this.flipDownCommand = flipDownCommand;
    }

    public void flipUp() {
        flipUpCommand.execute();
    }

    public void flipDown() {
        flipDownCommand.execute();
    }
}
