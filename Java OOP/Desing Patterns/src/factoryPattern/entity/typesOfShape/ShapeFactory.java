package factoryPattern.entity.typesOfShape;

import factoryPattern.interfaces.Shape;

public class ShapeFactory {

    Shape shape = null;

    public Shape getShape(String typeOfShape) {

        switch (typeOfShape) {

            case "Circle":
                shape = new Circle();
                break;
            case "Square":
                shape = new Square();
                break;
            case "Rectangle":
                shape = new Rectangle();
                break;
            default:
                throw new NullPointerException("shape dose not exist " + typeOfShape);
        }

        return shape;
    }
}
