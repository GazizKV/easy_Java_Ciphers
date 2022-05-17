package encryptdecrypt;

public class Criptographer {
    private Cripting criptor;

    public void setCriptor(Cripting criptor) {
        this.criptor = criptor;
    }

    public String decript(String message, int key) {
        return this.criptor.decript(message, key);
    }

    public String encript(String message, int key) {
        return this.criptor.encript(message, key);
    }

}
