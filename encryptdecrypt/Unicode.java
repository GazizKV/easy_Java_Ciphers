package encryptdecrypt;

public class Unicode implements Cripting {
    @Override
    public String encript(String message, int key) {
        String[] charsString = message.split("");
        StringBuilder result = new StringBuilder();
        for (String next : charsString) {
            result.append(Character.toString(next.charAt(0) + key));
        }
        return result.toString();
    }

    @Override
    public String decript(String message, int key) {
        String[] charsString = message.split("");
        StringBuilder result = new StringBuilder();
        for (String next : charsString) {
            result.append(Character.toString(next.charAt(0) - key));
        }
        return result.toString();
    }
}
