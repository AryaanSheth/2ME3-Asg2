/**
 * The type Encryption.
 */
abstract class encryption {

    /**
     * Encrypt string.
     *
     * @param text the text
     * @param key  the key
     * @return the string
     */
    public String encrypt( String text, int key) {
        // bit shift the text by the key value
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encryptedText.append((char) (text.charAt(i) + key));
        }
        return encryptedText.toString();
    }



    /**
     * Decrypt string.
     *
     * @param text the text
     * @param key  the key
     * @return the string
     */
    public String decrypt(String text, int key) {
        // bit shift the text by the key value
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            decryptedText.append((char) (text.charAt(i) - key));
        }
        return decryptedText.toString();
    }
}