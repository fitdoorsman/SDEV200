public class Exercise09_09 {

    public static void main(String[] args) {
        // Create 3 RegularPolygon objects
        RegularPolygon poly1 = new RegularPolygon();
        RegularPolygon poly2 = new RegularPolygon(6, 4);
        RegularPolygon poly3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // Display perimeter and area of each
        printPolygonInfo(poly1);
        printPolygonInfo(poly2);
        printPolygonInfo(poly3);
    }

    public static void printPolygonInfo(RegularPolygon p) {
        System.out.println("Perimeter: " + p.getPerimeter());
        System.out.println("Area: " + p.getArea());
        System.out.println();
    }
}

class RegularPolygon {
    private int n = 3;
    private double side = 1.0;
    private double x = 0.0;
    private double y = 0.0;

    // No-arg constructor
    public RegularPolygon() {}

    // Constructor with n and side
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    // Constructor with n, side, x, and y
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public int getN() { return n; }
    public void setN(int n) { this.n = n; }

    public double getSide() { return side; }
    public void setSide(double side) { this.side = side; }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    // Return perimeter
    public double getPerimeter() {
        return n * side;
    }

    // Return area
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}
