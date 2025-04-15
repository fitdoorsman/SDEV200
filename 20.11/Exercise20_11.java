import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Exercise20_11 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise20_11 filename.java");
            return;
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            System.out.println("File not found: " + args[0]);
            return;
        }

        Stack<Character> stack = new Stack<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                for (char ch : line.toCharArray()) {
                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    } else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Unmatched closing symbol: " + ch);
                            return;
                        }
                        char open = stack.pop();
                        if (!isMatchingPair(open, ch)) {
                            System.out.println("Mismatched pair: " + open + " and " + ch);
                            return;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File error: " + e.getMessage());
        }

        if (stack.isEmpty()) {
            System.out.println("Correct grouping pairs");
        } else {
            System.out.println("Unmatched opening symbol(s): " + stack);
        }
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
