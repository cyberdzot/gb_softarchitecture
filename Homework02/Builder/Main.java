package Homework02.Builder;

// Builder — это паттерн проектирования,
// который позволяет поэтапно создавать сложные объекты с помощью четко определенной последовательности действий.
// Строительство контролируется объектом-распорядителем (director), которому нужно знать только тип создаваемого объекта.

public class Main {
    public static void main(String[] args) {
        // какой то инженер получает задачу построить спорт-кар
        CarBuilder builder = new SportsCarBuilder();

        // этот инженер устроен на каком то заводе по производству автомобилей
        AutomotiveEngineer engineer = new AutomotiveEngineer(builder);

        // выпускаем автомобиль
        Car car = engineer.manufactureCar();
        if (car != null) {
            System.out.println("Приведенный ниже автомобиль доставлен: ");
            System.out.println("=========================================================================================================");
            System.out.println(car);
            System.out.println("=========================================================================================================");
        }
    }
}


class Car {
    private String chassis;
    private String body;
    private String paint;
    private String interior;

    public Car() {
        super();
    }

    public Car(String chassis, String body, String paint, String interior) {
        this();
        this.chassis = chassis;
        this.body = body;
        this.paint = paint;
        this.interior = interior;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public boolean doQualityCheck() {
        return (chassis != null && !chassis.trim().isEmpty()) && (body != null && !body.trim().isEmpty())
                && (paint != null && !paint.trim().isEmpty()) && (interior != null && !interior.trim().isEmpty());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Автомобиль - шасси: ").append(chassis).append(", кузов: ").append(body).append(", покраска: ").append(paint);
        return builder.toString();
    }
}

interface CarBuilder {
    // Этап 1
    public CarBuilder fixChassis();

    // Этап 2
    public CarBuilder fixBody();

    // Этап 3
    public CarBuilder paint();

    // Этап 4
    public CarBuilder fixInterior();

    // Выпуск автомобиля
    public Car build();
}

class ClassicCarBuilder implements CarBuilder {
    private String chassis;
    private String body;
    private String paint;
    private String interior;

    public ClassicCarBuilder() {
        super();
    }

    @Override
    public CarBuilder fixChassis() {
        System.out.println("Сборка шасси классической модели");
        this.chassis = "Классическое шасси";
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        System.out.println("Сборка кузова классической модели");
        this.body = "Классический кузов";
        return this;
    }

    @Override
    public CarBuilder paint() {
        System.out.println("Покраска кузова классической модели");
        this.paint = "Классическая белая краска";
        return this;
    }

    @Override
    public CarBuilder fixInterior() {
        System.out.println("Оформление интерьера по классическому образцу");
        this.interior = "Классический интерьер";
        return this;
    }

    @Override
    public Car build() {
        Car car = new Car(chassis, body, paint, interior);
        if (car.doQualityCheck()) {
            return car;
        } else {
            System.out.println("Сборка автомобиля не завершена. Не могу доставить!");
        }
        return null;
    }
}

class ModernCarBuilder implements CarBuilder {
    private String chassis;
    private String body;
    private String paint;
    private String interior;

    public ModernCarBuilder() {
        super();
    }

    @Override
    public CarBuilder fixChassis() {
        System.out.println("Сборка шасси современной модели");
        this.chassis = "Современное шасси";
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        System.out.println("Сборка кузова современной модели");
        this.body = "Современный кузов";
        return this;
    }

    @Override
    public CarBuilder paint() {
        System.out.println("Покраска кузова современной модели");
        this.paint = "Современная черная краска";
        return this;
    }

    @Override
    public CarBuilder fixInterior() {
        System.out.println("Создание интерьера современной модели");
        this.interior = "Современный интерьер";
        return this;
    }

    @Override
    public Car build() {
        Car car = new Car(chassis, body, paint, interior);
        if (car.doQualityCheck()) {
            return car;
        } else {
            System.out.println("Сборка автомобиля не завершена. Не могу доставить!");
        }
        return null;
    }
}

class SportsCarBuilder implements CarBuilder {
    private String chassis;
    private String body;
    private String paint;
    private String interior;

    public SportsCarBuilder() {
        super();
    }

    @Override
    public CarBuilder fixChassis() {
        System.out.println("Сборка шасси спортивной модели");
        this.chassis = "Спортивное шасси";
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        System.out.println("Сборка кузова спортивной модели");
        this.body = "Спортивный кузов";
        return this;
    }

    @Override
    public CarBuilder paint() {
        System.out.println("Покраска кузова спортивной модели");
        this.paint = "Спортивная краска Красный факел";
        return this;
    }

    @Override
    public CarBuilder fixInterior() {
        System.out.println("Настройка интерьера спортивной модели");
        this.interior = "Спортивный интерьер";
        return this;
    }

    @Override
    public Car build() {
        Car car = new Car(chassis, body, paint, interior);
        if (car.doQualityCheck()) {
            return car;
        } else {
            System.out.println("Сборка автомобиля не завершена. Не могу доставить!");
        }
        return null;
    }
}

class AutomotiveEngineer {
    private CarBuilder builder;

    public AutomotiveEngineer(CarBuilder builder) {
        super();
        this.builder = builder;
        if (this.builder == null) {
            throw new IllegalArgumentException("Инженер-автостроитель не может работать без автопроизводителя!");
        }
    }

    public Car manufactureCar() {
        return builder.fixChassis().fixBody().paint().fixInterior().build();
    }
}