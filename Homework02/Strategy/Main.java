package Homework02.Strategy;

// Стратегия - это когда мы определяем семейство алгоритмов, инкапсулируем каждый и делаем их взаимозаменяемыми.
// Стратегия позволяет алгоритму варьироваться независимо от клиентов, которые используют его.

public class Main {
    public static void main(String[] args) {
        Auto sedan = new Sedan();
        Auto hybrid = new HybridAuto();
        Auto f1car = new F1Car();

        // Просто заправляем бензин!
        sedan.fill();

        // Заправляем бензином или электричеством на выбор!
        hybrid.fill();

        // Заправляем бензин только после всех остальных процедур пит-стопа!
        f1car.fill();
    }
}

class Auto {
    FillStrategy fillStrategy;

    public void fill() {
        fillStrategy.fill();
    }
}

interface FillStrategy {
    public void fill();
}

class HybridFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Заправляем бензином или электричеством на выбор!");
    }
}

class F1PitstopStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Заправляем бензин только после всех остальных процедур пит-стопа!");
    }
}

class StandartFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Просто заправляем бензин!");
    }
}

class Sedan extends Auto {
    public Sedan() {
        this.fillStrategy = new StandartFillStrategy();
    }
}

class HybridAuto extends Auto {
    public HybridAuto() {
        this.fillStrategy = new HybridFillStrategy();
    }
}

class F1Car extends Auto {
    public F1Car() {
        this.fillStrategy = new F1PitstopStrategy();
    }
}
