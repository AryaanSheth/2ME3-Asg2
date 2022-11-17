import java.util.ArrayList;

/**
 * The type Home base -- Singleton
 *
 * @param <T> the type parameter
 */
public class homeBase<T> {
    private static homeBase instance;
    private static encryptionInterface encryption;
    private final ArrayList<fieldBaseInterface<T>> fieldBases = new ArrayList<>(); // list of field bases
    private int key;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static homeBase getInstance() {
        if (instance == null) {
            System.out.println("Creating New Home Base");
            instance = new homeBase();
            setKey(0); // default key
            encryption = new bitshift(); // default encryption
        }
        return instance;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public static int getKey() {
        return instance.key;
    }

    private static void setKey(int key) {
        instance.key = key;
    }

    /**
     * Add field base.
     *
     * @param field the field
     */
    public void addFieldBase(fieldBaseInterface<T> field) {
        fieldBases.add(field);
    } // subscribe/register

    /**
     * Remove field base.
     *
     * @param field the field
     */
    public void removeFieldBase(fieldBaseInterface<T> field) {
        fieldBases.remove(field);
    } // unsubscribe/unregister


    /**
     * Sets strategy.
     *
     * @param strategy the strategy
     */
    public void setStrategy(String strategy) { // set encryption strategy
        switch (strategy) {
            case "CaesarCipher" -> encryption = new CaesarCipher();
            case "bitshift" -> encryption = new bitshift();
            default -> System.out.println("Invalid Strategy");
        }
    }

    /**
     * Gets encryption.
     *
     * @return the encryption
     */
    public encryptionInterface getEncryption() {
        return encryption;
    }

    /**
     * Send message.
     *
     * @param target  the target
     * @param message the message
     * @throws Exception the exception
     */
// send a message to either a specific field base or a specific spy using the generic type <T>
    public void sendMessage(T target, String message) throws Exception {
        // send message to a specific instance of a field baseS
        if (target instanceof fieldBaseInterface) { // for each field base in the list
            System.out.println("Sending message to field base");
            // send the current scheme and key to the field
            ((fieldBaseInterface<T>) target).recieveMessage(encryption.encrypt(message, getKey()));
        }
        // send message to a specific instance of a spy
        else if (target instanceof spyInterface) {
            System.out.println("Sending message to spy");
            ((spyInterface<T>) target).recieveMessage(encryption.decrypt(message, getKey()));
        } else {
            throw new Exception("Invalid target");
        }
    }


    /**
     * Receive message.
     *
     * @param message the message
     */
    public void receiveMessage(String message) {
        System.out.println("Recieved message: " + encryption.decrypt(message, getKey()));
    }


}