import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountKeywords {
    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        try (Scanner input = new Scanner(file)) {
            boolean isInComment = false;

            while (input.hasNext()) {
                String word = input.next();
                if (!isInComment && !word.startsWith("\"") && !word.startsWith("//") && !word.startsWith("/*")) {
                    if (word.startsWith("\"")) {
                        while (!word.endsWith("\"")) {
                            word += " " + input.next();
                        }
                        if (word.endsWith("\""))
                            continue;
                    }
                    if (word.startsWith("//")) {
                        input.nextLine();
                        continue;
                    }
                    if (word.startsWith("/*")) {
                        isInComment = true;
                        while (!word.endsWith("*/")) {
                            word = input.next();
                        }
                        if (word.endsWith("*/"))
                            isInComment = false;
                        continue;
                    }
                    if (keywordSet.contains(word))
                        count++;
                }
            }
        }

        return count;
    }
}