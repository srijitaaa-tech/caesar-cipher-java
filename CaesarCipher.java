import java.util.Scanner;

public class CaesarCipher {

    public static String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = ((shift % 26) + 26) % 26;

        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Caesar Cipher Tool");

        while (true) {
            System.out.println("\n1. Encrypt\n2. Decrypt\n3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            }
            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Invalid option.");
                continue;
            }

            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            System.out.print("Enter shift (number): ");
            int shift;
            try {
                shift = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Shift must be a number.");
                continue;
            }

            if (choice.equals("1")) {
                System.out.println("Encrypted: " + shiftText(text, shift));
            } else {
                System.out.println("Decrypted: " + shiftText(text, -shift));
            }
        }
        scanner.close();
    }
}
