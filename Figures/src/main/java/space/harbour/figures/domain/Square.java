package space.harbour.figures.domain;

public class Square implements Figure {
    private float side;

    public Square(float side) {
        this.side = side;
    }

    @Override
    public float getArea() {
        return side * side;
    }

    @Override
    public float getPerimeter() {
        return side * 4;
    }
}
