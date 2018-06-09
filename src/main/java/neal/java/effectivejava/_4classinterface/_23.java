package neal.java.effectivejava._4classinterface;

/**
 * Item 23: Prefer class hierarchies to tagged classes
 */
public class _23 {

    // Tagged class - vastly inferior to a class hierarchy!
    static class Figure {
         enum Shape {RECTANGLE, CIRCLE}

        ;
        // Tag field - the shape of this figure
        final Shape shape;
        // These fields are used only if shape is RECTANGLE
        double length;
        double width;
        // This field is used only if shape is CIRCLE
        double radius;

        // Constructor for circle
        Figure(double radius) {
            shape = Shape.CIRCLE;
            this.radius = radius;
        }

        // Constructor for rectangle
        Figure(double length, double width) {
            shape = Shape.RECTANGLE;
            this.length = length;
            this.width = width;
        }

        double area() {
            switch (shape) {
                case RECTANGLE:
                    return length * width;
                case CIRCLE:
                    return Math.PI * (radius * radius);
                default:
                    throw new AssertionError(shape);
            }
        }
    }






    // Class hierarchy replacement for a tagged class
    abstract class Figure2 {
        abstract double area();
    }
    class Circle extends Figure2 {
        final double radius;
        Circle(double radius) { this.radius = radius; }
        @Override double area() { return Math.PI * (radius * radius); }
    }
    class Rectangle extends Figure2 {
        final double length;
        final double width;
        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }@
        Override double area() { return length * width; }
    }

    class Square extends Rectangle {
        Square(double side) {
            super(side, side);
        }}
}
