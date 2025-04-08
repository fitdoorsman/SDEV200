public class TestCircle {
    public static void main(String[] args) {
        // Create two Circle objects
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(5.0);
        Circle circle3 = new Circle(7.5);

        // Compare circle1 and circle2 (should be equal)
        System.out.println("circle1 equals circle2: " + circle1.equals(circle2));
        System.out.println("circle1 compareTo circle2: " + circle1.compareTo(circle2));

        // Compare circle1 and circle3 (should not be equal)
        System.out.println("circle1 equals circle3: " + circle1.equals(circle3));
        System.out.println("circle1 compareTo circle3: " + circle1.compareTo(circle3));

        // Print areas and perimeters
        System.out.println("circle1 area: " + circle1.getArea());
        System.out.println("circle1 perimeter: " + circle1.getPerimeter());

        System.out.println("circle3 area: " + circle3.getArea());
        System.out.println("circle3 perimeter: " + circle3.getPerimeter());
    }
}
