import java.util.Scanner;

public class TestBinaryConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String binary = input.nextLine();

        try {
            int decimal = BinaryConverter.bin2Dec(binary);
            System.out.println("Decimal value: " + decimal);
        } catch (BinaryFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
