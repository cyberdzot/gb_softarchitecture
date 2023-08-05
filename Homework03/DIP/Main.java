package Homework03.DIP;

public class Main {
    public static void main(String[] args) {
        Text myText = new Text("Hello, world!");

        Printer myPrinter = new Printer();
        MFD myMfd = new MFD();

        myPrinter.print(myText);
        myMfd.print(myText);
    }
}

interface IPrintText {
    void print(Text text);
}

class Text {
    String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class Printer implements IPrintText {
    public void print(Text text) {
        System.out.println("На вашем принтере вышла печать: " + text.getText());
    }
}

// теперь можно привязать к выводу/печати текста ещё что то...
class MFD implements IPrintText {
    public void print(Text text) {
        System.out.println("На вашем МФУ вышла печать: " + text.getText());
    }
}
