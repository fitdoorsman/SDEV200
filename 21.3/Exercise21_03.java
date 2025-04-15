import java.io.*;
import java.util.*;

public class Exercise21_03 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise21_03 filename.java");
            return;
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            System.out.println("File not found: " + args[0]);
            return;
        }

        System.out.println("The program is");
        printFileContents(file);

        System.out.println("\nThe number of keywords in " + args[0] + " is " + countKeywords(file));
    }

    public static int countKeywords(File file) throws Exception {
        String[] keywordArray = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
        };

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordArray));

        int count = 0;
        Scanner input = new Scanner(file);

        boolean inBlockComment = false;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            if (line.startsWith("/*")) {
                inBlockComment = true;
            }

            if (inBlockComment) {
                if (line.endsWith("*/")) {
                    inBlockComment = false;
                }
                continue;
            }

            if (line.startsWith("//")) {
                continue; // Skip line comments
            }

            // Remove strings in quotes
            line = line.replaceAll("\".*?\"", "");

            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                if (keywordSet.contains(word)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void printFileContents(File file) throws Exception {
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
    }
}
