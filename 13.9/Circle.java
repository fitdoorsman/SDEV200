public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public int compareTo(Circle other) {
        return Double.compare(this.radius, other.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle other = (Circle) obj;
            return this.radius == other.radius;
        }
        return false;
    }

    public void printCircle() {
        System.out.println("Radius: " + radius);
    }
}
