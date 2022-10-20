package space.harbour.figures.domain;

public class Circle implements Figure {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (radius * radius * Math.PI);
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * Math.PI * radius);
    }
}
