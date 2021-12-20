package factoryPattern;

import factoryPattern.entity.typesOfShape.ShapeFactory;
import factoryPattern.interfaces.Shape;


public class Main {
    public static void main(String[] args) {

        // In Factory pattern,we create object without exposing
        // the creation logic to the client and refer to newly created object using a common interface.

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape = shapeFactory.getShape("Circle");
        Shape shape1 = shapeFactory.getShape("Square");

        shape.draw();
        shape1.draw();
    }
}
