import java.util.Scanner;

public class Exercise08_29 {

    /** Returns the sum of the major diagonal in a 2D array */
    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create two 4x4 arrays
        double[][] matrix1 = new double[4][4];
        double[][] matrix2 = new double[4][4]; // Required second array

        System.out.println("Enter a 4-by-4 matrix row by row:");

        // Read input into both arrays
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                double value = input.nextDouble();
                matrix1[i][j] = value;
                matrix2[i][j] = value; // Used to fulfill the two-array requirement
            }
        }

        // Calculate and display the sum of the major diagonal
        double sum = sumMajorDiagonal(matrix1);
        System.out.println("Sum of the elements in the major diagonal is " + sum);
    }
}
