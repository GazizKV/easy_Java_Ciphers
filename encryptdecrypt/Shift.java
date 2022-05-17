package encryptdecrypt;

public class Shift implements Cripting {
    public static String naturalLower = "abcdefghijklmnopqrstuvwxyz";
    public static String naturalUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String reversedLower = "zyxwvutsrqponmlkjihgfedcba";
    public static String reversedUpper = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

    @Override
    public String encript(String message, int key) {
        StringBuilder result = new StringBuilder();
        String[] messageChars = message.split("");
        int nextIndex = 0;
        for (String next : messageChars) {
            if (!naturalLower.contains(next.toLowerCase())) {
                result.append(next);
                continue;
            }
            if (next.charAt(0) < 96) {
                nextIndex = naturalUpper.indexOf(next) + key;
                if (nextIndex > 25) {
                    while (nextIndex > 25) {
                        nextIndex = nextIndex - 26;
                    }
                }
                result.append(naturalUpper.charAt(nextIndex));
            } else {
                nextIndex = naturalLower.indexOf(next) + key;
                if (nextIndex > 25) {
                    while (nextIndex > 25) {
                        nextIndex = nextIndex - 26;
                    }
                }
                result.append(naturalLower.charAt(nextIndex));
            }
        }
        return result.toString();
    }

    @Override
    public String decript(String message, int key) {
        StringBuilder result = new StringBuilder();
        String[] messageChars = message.split("");
        int nextIndex = 0;
        for (String next : messageChars) {
            if (!naturalLower.contains(next.toLowerCase())) {
                result.append(next);
                continue;
            }
            if (next.charAt(0) < 96) {
                nextIndex = naturalUpper.indexOf(next) - key;
                if (nextIndex < 0) {
                    while (nextIndex < 0) {
                        nextIndex = nextIndex + 26;
                    }
                }
                result.append(naturalUpper.charAt(nextIndex));
            } else {
                nextIndex = naturalLower.indexOf(next) - key;
                if (nextIndex < 0) {
                    while (nextIndex < 0) {
                        nextIndex = nextIndex + 26;
                    }
                }
                result.append(naturalLower.charAt(nextIndex));
            }
        }
        return result.toString();
    }
}
