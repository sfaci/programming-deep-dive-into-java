package space.harbour.figures;

public class Square implements Figure {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }

    @Override
    public int perimeter() {
        return side * 4;
    }
}
