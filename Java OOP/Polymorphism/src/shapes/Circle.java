package shapes;

public class Circle extends Shape{
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter( Math.PI * radius * radius);
    }

    @Override
    public void calculateArea() {
        setArea( Math.pow(radius,2));
    }
}
