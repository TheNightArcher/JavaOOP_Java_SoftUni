package shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();


    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        if (perimeter == null) {
            calculatePerimeter();
        }
        return perimeter;
    }

    public Double getArea() {
        if (area == null) {
            calculateArea();
        }
        return area;
    }
}
