/**
 * The type Spy.
 *
 * @param <T> the type parameter
 */
public class spy<T> extends bitshift implements spyInterface {
    private static encryptionInterface encryption;
    /**
     * The State.
     */
    boolean state;
    /**
     * The Base.
     */
    fieldBase base;
    /**
     * The Key.
     */
    int key;


    /**
     * Instantiates a new Spy.
     *
     * @param base the base
     */
// constructor
    spy(fieldBase base) {
        state = true;
        this.base = base;
        getKey();
        encryption = base.getEncryption();
        register();
    }


    /**
     * Gets key.
     */
    void getKey() {
        key = base.getKey();
    }


    @Override
    public void die() {
        state = false;
        base.removeSpy(this);
    }

    @Override
    public void register() {
        if (state) {
            base.addSpy(this);
        } else {
            System.out.println("Cannot register dead spy");
        }
    }


    @Override
    public void sendMessage(Object target, String message) throws Exception {
        getKey(); // update key
        // send message to a specific instance of a field base
        if (target instanceof homeBase) {
            System.out.println("Sending message to Home Base");
            ((homeBase<?>) target).receiveMessage(encryption.encrypt(message, base.getKey()));
        }
        // send message to a specific instance of a spy
        else if (target instanceof fieldBaseInterface<?>) {
            System.out.println("Sending message to spy");
            ((fieldBaseInterface<?>) target).recieveMessage(encryption.encrypt(message, base.getKey()));
        } else {
            throw new Exception("Invalid target");
        }
    }

    @Override
    public void recieveMessage(String message) {
        getKey(); // update key
        System.out.println("Recieved message: " + encryption.decrypt(message, base.getKey()));
    }

}
