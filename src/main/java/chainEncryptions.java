import java.util.ArrayList;

public class chainEncryptions implements encryptionInterface {

    private encryptionInterface encryptiona;
    private encryptionInterface encryptionb;

    // constructor
    chainEncryptions(encryptionInterface encryptiona, encryptionInterface encryptionb) { // constructor, combine two encryption's
        this.encryptiona = encryptiona;
        this.encryptionb = encryptionb;

    }

    @Override
    public String encrypt(String text, int key) {
        return encryptiona.encrypt(encryptionb.encrypt(text, key), key);
    }

    @Override
    public String decrypt(String text, int key) {
        return encryptionb.decrypt(encryptiona.decrypt(text, key), key); // reverse order of encryption chain
    }
}