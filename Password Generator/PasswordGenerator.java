import java.util.*;

public class PasswordGenerator {

    public static String generatePassword(int length, boolean useLower, boolean useUpper, boolean useNumbers, boolean useSymbols) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()";
        StringBuilder allCharacters = new StringBuilder();
        List<Character> passwordChars = new ArrayList<>();
        Random rand = new Random();
        if (useLower) {
            allCharacters.append(lowercase);
            passwordChars.add(lowercase.charAt(rand.nextInt(lowercase.length())));
        }
        if (useUpper) {
            allCharacters.append(uppercase);
            passwordChars.add(uppercase.charAt(rand.nextInt(uppercase.length())));
        }
        if (useNumbers) {
            allCharacters.append(numbers);
            passwordChars.add(numbers.charAt(rand.nextInt(numbers.length())));
        }
        if (useSymbols) {
            allCharacters.append(symbols);
            passwordChars.add(symbols.charAt(rand.nextInt(symbols.length())));
        }

        if (allCharacters.length() == 0) return "Error: No character set selected!";
        if (length < passwordChars.size()) return "Error: Length too short for selected character types.";
        for (int i = passwordChars.size(); i < length; i++) {
            passwordChars.add(allCharacters.charAt(rand.nextInt(allCharacters.length())));
        }
        Collections.shuffle(passwordChars);
        StringBuilder password = new StringBuilder();
        for (char ch : passwordChars) {
            password.append(ch);
        }
        return password.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Password Length: ");
        int length = sc.nextInt();
        System.out.print("Include Lowercase? (true/false): ");
        boolean lower = sc.nextBoolean();
        System.out.print("Include Uppercase? (true/false): ");
        boolean upper = sc.nextBoolean();
        System.out.print("Include Numbers? (true/false): ");
        boolean numbers = sc.nextBoolean();
        System.out.print("Include Symbols? (true/false): ");
        boolean symbols = sc.nextBoolean();
        String password = generatePassword(length, lower, upper, numbers, symbols);
        System.out.println("\nGenerated Password: " + password);
        sc.close();
    }
}
