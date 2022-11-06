import org.jetbrains.annotations.NotNull;

// Singleton Obj for HomeBase
public class homeBase implements encryption {
    private static homeBase instance = null;
    private int key;

    // Singleton Instance for HomeBase Class
    public static homeBase getInstance() {
        if (instance == null) {
            System.out.println("Creating new instance");
            instance = new homeBase();
        }
        return instance;
    }

    // encryption.java, bitshifts the text by the key
    @Override
    public String encrypt(@NotNull String text, int key) {
        this.key = key;
        // bit shift the text by the key value
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encryptedText.append((char) (text.charAt(i) + key));
        }
        return encryptedText.toString();
    }

    @Override
    public String decrypt(String text, int key) {
        this.key = key;
        // bit shift the text by the key value
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            decryptedText.append((char) (text.charAt(i) - key));
        }
        return decryptedText.toString();
    }
}