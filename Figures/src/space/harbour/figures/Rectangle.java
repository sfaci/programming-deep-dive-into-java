package space.harbour.figures;

public class Rectangle implements Figure{

    private int width;
    private int height;

    @Override
    public int area() {
        return width * height;
    }

    @Override
    public int perimeter() {
        return width * 2 + height * 2;
    }
}
