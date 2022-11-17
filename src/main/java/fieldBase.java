import java.util.ArrayList;

/**
 * The type Field base.
 */
public class fieldBase extends bitshift implements fieldBaseInterface {
    private static encryptionInterface encryption;
    private final ArrayList<spyInterface<?>> spy = new ArrayList<>();
    /**
     * The Key.
     */
    int key;


    /**
     * Instantiates a new Field base.
     */
//constructor
    fieldBase() {
        homeBase.getInstance().addFieldBase(this);
        getKey();

    }


    /**
     * Gets key.
     *
     * @return the key
     */
    public int getKey() {
        key = homeBase.getInstance().getKey();
        return key;

    }

    /**
     * Gets encryption.
     *
     * @return the encryption
     */
    public encryptionInterface getEncryption() {
        encryption = homeBase.getInstance().getEncryption();
        return encryption;
    }


    @Override
    public void goDark() {
        homeBase.getInstance().removeFieldBase(this);
    }

    @Override
    public void goLive() {
        homeBase.getInstance().addFieldBase(this);
    }


    @Override
    public void sendMessage(Object target, String message) throws Exception {
        // send message to a specific instance of a field base
        if (target instanceof homeBase) {
            ((homeBase<?>) target).receiveMessage(encryption.encrypt(message, getKey()));
        }
        // send message to a specific instance of a spy
        else if (target instanceof spyInterface) {
            ((spyInterface<?>) target).recieveMessage(encryption.encrypt(message, getKey()));
        } else {
            throw new Exception("Invalid target");
        }
    }

    @Override
    public void recieveMessage(String message) {
        getKey(); // update key
        System.out.println("Received message: " + encryption.decrypt(message, key));
    }

    /**
     * Add spy.
     *
     * @param spy the spy
     */
// all spies registered with this field base
    public void addSpy(spyInterface<?> spy) {
        this.spy.add(spy);
    }

    /**
     * Remove spy.
     *
     * @param spy the spy
     */
    public void removeSpy(spyInterface<?> spy) {
        this.spy.remove(spy);
    }

    public int getNumSpies() {
        return spy.size();
    }


}

