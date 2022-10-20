package space.harbour.figures;

import space.harbour.figures.domain.*;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(45);
        Figure figure = new Square(10);

        System.out.println(circle.getArea());
        System.out.println(figure.getPerimeter());

        doSomethingWithAnyFigure(circle);
        doSomethingWithAnyFigure(figure);

        figure = new Rectangle(10, 10);
        System.out.println(figure.getArea());
    }

    public static void doSomethingWithAnyFigure(Figure figure) {
        System.out.println(figure.getArea());
    }
}