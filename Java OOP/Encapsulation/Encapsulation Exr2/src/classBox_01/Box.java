package classBox_01;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {

        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isInvalid(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    private void setWidth(double width) {

        if (isInvalid(width)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {

            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (isInvalid(height)) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }

    private boolean isInvalid(double parameter) {
        return parameter <= 0;
    }

    public double calculateSurfaceArea() {
        return 2 * ((length * width) + (length * height) + (width * height));
    }

    public double calculateLateralSurfaceArea() {

        return 2 * (length * height + width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
