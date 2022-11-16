

import java.util.ArrayList;

/**
 * The type Home base -- Singleton
 */
public class homeBase<T>{
    private static homeBase instance;
    private static int key;
    private static encryptionInterface encryption;
    private final ArrayList<fieldBaseInterface<T>> fieldBases = new ArrayList<>(); // list of field bases

    public static homeBase getInstance() {
        if (instance == null) {
            System.out.println("Creating New Home Base");
            instance = new homeBase();
            instance.setKey(7);
            encryption = new bitshift();
        }
        return instance;
    }

    public static int getKey() {
        return key;
    }
    private static void setKey(int key){homeBase.key = key;}

    public void addFieldBase(fieldBaseInterface<T> field) {fieldBases.add(field);} // subscribe
    public void removeFieldBase(fieldBaseInterface<T> field) {fieldBases.remove(field);} // unsubscribe
    public int getFieldBases() {return fieldBases.size();}

    public void setStrategy(String strategy) { // set encryption strategy
        switch (strategy) {
            case "CaesarCipher" -> encryption = new CaesarCipher();
            case "bitshift" -> encryption = new bitshift();
            default -> System.out.println("Invalid Strategy");
        }
    }

    public encryptionInterface getStrategy() { // get encryption strategy
        return encryption;
    }

    // send a message to either a specific field base or a specific spy using the generic type <T>
    public void sendMessage(T target, String message) throws Exception {
        // send message to a specific instance of a field baseS
        if (target instanceof fieldBaseInterface){ // for each field base in the list
            System.out.println("Sending message to field base");
            ((fieldBaseInterface<T>) target).recieveMessage(encryption.encrypt(message, key));
        }
        // send message to a specific instance of a spy
        else if (target instanceof spyInterface){
            System.out.println("Sending message to spy");
            ((spyInterface<T>) target).recieveMessage(encryption.decrypt(message, key));
        }
        else{
            throw new Exception("Invalid target");
        }
    }
    public void recieveMessage(String message) {
        System.out.println("Recieved message: " + encryption.decrypt(message, key));
    }




}