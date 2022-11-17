/**
 * The interface Encryption interface.
 */
public interface encryptionInterface {

    /**
     * Encrypt string.
     *
     * @param text the text
     * @param key  the key
     * @return the string
     */
    String encrypt(String text, int key);

    /**
     * Decrypt string.
     *
     * @param text the text
     * @param key  the key
     * @return the string
     */
    String decrypt(String text, int key);

}
