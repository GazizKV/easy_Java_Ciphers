
package encryptdecrypt;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Criptographer criptographer = new Criptographer();
    public static HashMap<String, String> settings = new HashMap<>();
    public static CriptFactory criptFactory = new CriptFactoryImpl();

    static {
        settings.put("-mode", "enc");
        settings.put("-key", "0");
        settings.put("-data", "");
        settings.put("-out", "");
        settings.put("-in", "");
        settings.put("-alg", "shft");
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i += 2) {
            settings.put(args[i], args[i + 1]);
        }
        criptographer.setCriptor(criptFactory.createCriptor(settings.get("-alg")));
        String out = "Error";
        if (!settings.get("-in").equals("")) {
            String inputString = getInputMessageFromFile(settings.get("-in"));
            settings.put("-data", inputString);
        }

        if (settings.get("-mode").equals("enc")) {
            out = criptographer.encript(settings.get("-data"), Integer.parseInt(settings.get("-key")));
        } else if (settings.get("-mode").equals("dec")) {
            out = criptographer.decript(settings.get("-data"), Integer.parseInt(settings.get("-key")));
        } else {
            System.out.println("Error");
        }

        if (settings.get("-out").equals("")) {
            System.out.println(out);
        } else {
            printToFile(out);
        }

    }

    private static String getInputMessageFromFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(fileName))
        ) {
            while (reader.ready()) {
                result.append(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    private static void printToFile(String out) {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(settings.get("-out")))
        ) {
            writer.write(out);
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String decFromFile(String s, String key) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    private static String encFromFile(String s, String key) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    private static String dec(String[] message, String key) {
        if (message.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String s : message) {
            result.append(Character.toString(s.charAt(0) - Integer.parseInt(key)));
        }
        return result.toString();
    }

    private static String enc(String[] message, String key) {
        StringBuilder result = new StringBuilder();
        if (message.length == 0 || (message.length == 1 && message[0].equals(""))) {
            return "";
        }
        for (String s : message) {
            result.append(Character.toString(s.charAt(0) + Integer.parseInt(key)));
        }
        return result.toString();
    }
}
