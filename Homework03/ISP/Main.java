package Homework03.ISP;

public class Main {
    public static void main(String[] args) {
        RobotWorker rWorker = new RobotWorker();
        rWorker.work();

        HumanWorker hWorker = new HumanWorker();
        hWorker.eat();
        hWorker.work();
    }
}


// рабочее поведение
interface IWork {
    void work();
}

// отдых или перекус, что нужно человеку
interface IRelax {
    void eat();
}

class HumanWorker implements IWork, IRelax {
    public void work() {
        System.out.println("Человек работает");
    }

    public void eat() {
        System.out.println("Человек ест");
    }
}

class RobotWorker implements IWork {
    public void work() {
        System.out.println("Робот работает");
    }
}
