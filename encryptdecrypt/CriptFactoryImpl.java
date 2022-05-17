package encryptdecrypt;

public class CriptFactoryImpl implements CriptFactory {
    @Override
    public Cripting createCriptor(String type) {
        switch (type) {
            case "shift": return new Shift();
            case "unicode": return new Unicode();
            default: return null;
        }
    }
}
