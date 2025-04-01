public class BinaryConverter {
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        int decimal = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            decimal = decimal * 2 + (binaryString.charAt(i) - '0');
        }
        return decimal;
    }
}
