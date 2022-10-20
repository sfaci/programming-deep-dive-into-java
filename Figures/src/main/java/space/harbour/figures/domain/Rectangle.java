package space.harbour.figures.domain;

public class Rectangle implements Figure {

    private float width;
    private float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public float getPerimeter() {
        return width * 2 + height * 2;
    }
}
