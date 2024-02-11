import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();
        File file = new File(filename);

        if (!file.exists()) {
            String[] parts = filename.split("\\\\");
            String filenameWithoutPath = parts[parts.length - 1];
            System.out.println("File " + filenameWithoutPath + " does not exist");
        } else {
            try {
                int count = CountKeywords.countKeywords(file);
                System.out.println("The number of keywords in " + file.getName() + " is " + count);
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
