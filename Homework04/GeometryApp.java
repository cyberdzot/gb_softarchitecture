package Homework04;

/**
 * Класс - круг с аргументом <b>radius</b>.
 * 
 * @version 0.1.0
 */
class Circle {
    /** Значение радиуса */
    private double radius;

    /**
     * Конструктор для создания круга.
     *
     * @param radius радиус круга.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Метод для расчёта площади круга.
     *
     * @return Площадь круга.
     * @see Circle#radius
     * @see Math#PI
     */
    double getAreaCircle() {
        return Math.PI * radius * radius;
    }

    /**
     * Метод для расчёта периметра круга.
     *
     * @return Периметр круга.
     * @see Circle#radius
     * @see Math#PI
     */
    double getPerimeterCircle() {
        return 2 * Math.PI * radius;
    }
}

/**
 * Класс - прямоугольник с аргументами <b>lenght</b>, <b>width</b>.
 * 
 * @version 0.1.0
 */
class Rectangle {
    /** Значение длины. */
    private double length;

    /** Значение ширины. */
    private double width;

    /**
     * Конструктор для создания прямоугольника.
     *
     * @param length длина.
     * @param width  ширина.
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Метод для расчёта площади прямоугольника.
     *
     * @return Площадь прямоугольника.
     * @see Rectangle#length
     * @see Rectangle#width
     */
    double getAreaRectangle() {
        return length * width;
    }

    /**
     * Метод для расчёта периметра прямоугольника.
     *
     * @return Периметр прямоугольника.
     * @see Rectangle#length
     * @see Rectangle#width
     */
    double getPerimeterRectangle() {
        return 2 * (length + width);
    }
}

/**
 * Треугольник с аргументами <b>side1</b>, <b>side2</b>, <b>side3</b>.
 * 
 * @version 0.1.0
 */
class Triangle {
    /** Значение стороны 1. */
    private double side1;

    /** Значение стороны 2. */
    private double side2;

    /** Значение стороны 3. */
    private double side3;

    /**
     * Конструктор для создания треугольника.
     *
     * @param side1 сторона 1.
     * @param side2 сторона 2.
     * @param side3 сторона 3.
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Метод для расчёта периметра треугольника.
     *
     * @return Периметр треугольника.
     * @see Triangle#side1
     * @see Triangle#side2
     * @see Triangle#side3
     */
    double getAreaTriangle() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Метод для расчёта периметра треугольника.
     *
     * @return Периметр треугольника.
     * @see Triangle#side1
     * @see Triangle#side2
     * @see Triangle#side3
     * @value double
     */
    double getPerimeterTriangle() {
        return side1 + side2 + side3;
    }
}

/**
 * Точка входа - Приложение "Фигуры"
 * 
 * @version 0.1.0
 */
public class GeometryApp {
    public static void main(String[] args) {
        // Пример использования конкретных классов геометрических фигур
        Circle circle = new Circle(5.0);
        System.out.println("Площадь круга: " + circle.getAreaCircle());
        System.out.println("Периметр круга: " + circle.getPerimeterCircle());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangle.getAreaRectangle());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeterRectangle());

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangle.getAreaTriangle());
        System.out.println("Периметр треугольника: " + triangle.getPerimeterTriangle());
    }
}