package shapes;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter( 2 * (getHeight() + getWidth()));
    }

    @Override
    public void calculateArea() {
       super.setArea( getHeight() * getWidth());
    }
}
