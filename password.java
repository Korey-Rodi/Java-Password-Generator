import java.util.Scanner;
import java.security.SecureRandom;

public class Password {
    public static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:',.<>";
    private static final Scanner scanner = new Scanner(System.in);




    public static String generatePassword(String includedCharacters, int passwordLength) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
        int randomIndex = random.nextInt(includedCharacters.length());
        password.append(includedCharacters.charAt(randomIndex));
        }
        return password.toString();
    }


    public static String checkDesiredPassword(String includeLetters, String includeNumbers, 
        String includeSymbols){
        String passwordCharacters = "";
            if (includeLetters.equalsIgnoreCase("y") || includeLetters.equalsIgnoreCase("yes")) {
                passwordCharacters += LETTERS;
            }
            if (includeNumbers.equalsIgnoreCase("y" ) || includeNumbers.equalsIgnoreCase("yes")) {
                passwordCharacters += NUMBERS;
            }
            if (includeSymbols.equalsIgnoreCase("y") || includeSymbols.equalsIgnoreCase("yes")) {
                passwordCharacters += SYMBOLS;
            }
        return passwordCharacters;

    }
    public static int passwordLength() {
        int passwordLength;
        System.out.print("Length of password? ");
        passwordLength = scanner.nextInt();
        scanner.nextLine();
        while (passwordLength < 12  || passwordLength > 20) {
            System.out.println("Password length must be between 12 and 20 characters.");
            System.out.println("Please enter a valid length: ");
            passwordLength = scanner.nextInt();
            scanner.nextLine();
        }
        return passwordLength;
    }

    public static String passwordMakeUp() {
        String includedCharacters = "";
        while (includedCharacters.length() == 0) {
        System.out.println("=======================================");
        System.out.println("Enter Y/N for each of the following criteria:");
        System.out.print("Include Letters? ");
        String includeLetters = scanner.nextLine();
        System.out.print("Include Numbers? ");
        String includeNumbers = scanner.nextLine();
        System.out.print("Include Symbols? ");
        String includeSymbols = scanner.nextLine(); 
        includedCharacters = checkDesiredPassword(includeLetters,includeNumbers, 
            includeSymbols);
        if (includedCharacters.length() == 0) {
                System.out.println("You must select at least one character type!");
                System.out.println("Please try again.");
        }
        }
        return includedCharacters;
    }
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("Welcome to the Java password generator!");
        int passwordLength = passwordLength();
        String includedCharacters = passwordMakeUp();
        String GeneratedPassword = generatePassword(includedCharacters,passwordLength);
        System.out.println("Generated Password: " + GeneratedPassword);
        scanner.close();

    }
}