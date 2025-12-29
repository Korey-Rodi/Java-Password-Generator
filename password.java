import java.util.Scanner;
import java.security.SecureRandom;

public class password {
    final public static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final public static String NUMBERS = "0123456789";
    final public static String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:',.<>";


    public static String generatePassword(String includedCharacters) {

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++) {
        int randomIndex = random.nextInt(includedCharacters.length());
        password.append(includedCharacters.charAt(randomIndex));
        }
        return password.toString();
    }


    public static String checkDesiredPassword(String includeLetters, String includeNumbers, 
        String includeSymbols){
        String passwordCharacters = "";
            if (includeLetters.equalsIgnoreCase("y")) {
                passwordCharacters += LETTERS;
            }
            if (includeNumbers.equalsIgnoreCase("y")) {
                passwordCharacters += NUMBERS;
            }
            if (includeSymbols.equalsIgnoreCase("y")) {
                passwordCharacters += SYMBOLS;
            }
            if (passwordCharacters.length() == 0) {
                System.out.println("You must select at least one character type!");
                System.out.println("Please try again.");
                passwordCriteria();

            }
        return passwordCharacters;

    }
    public static String passwordCriteria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("Enter Y/N for each of the following criteria:");
        System.out.print("Include Letters? ");
        String includeLetters = scanner.nextLine();
        System.out.print("Include Numbers? ");
        String includeNumbers = scanner.nextLine();
        System.out.print("Include Symbols? ");
        String includeSymbols = scanner.nextLine(); 
        String includedCharacters = checkDesiredPassword(includeLetters,includeNumbers, 
            includeSymbols);
        scanner.close();
        return includedCharacters;
    }
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("Welcome to the Java password generator!");
        String includedCharacters = passwordCriteria();
        String GeneratedPassword = generatePassword(includedCharacters);
        System.out.println("Generated Password: " + GeneratedPassword);

    }
}