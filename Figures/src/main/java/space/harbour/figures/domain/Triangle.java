package space.harbour.figures.domain;

public class Triangle implements Figure {

    private float base;
    private float height;
    private float side1, side2, side3;

    public Triangle(float base, float height, float side1, float side2, float side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public float getArea() {
        return base * height / 2;
    }

    @Override
    public float getPerimeter() {
        return side1 + side2 + side3;
    }
}
