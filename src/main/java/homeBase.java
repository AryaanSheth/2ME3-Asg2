import java.util.ArrayList;

/**
 * The type Home base -- Singleton
 */
public class homeBase<T> extends encryption{
    private static homeBase instance;
    private static int key;
    private static char encodingProtocol;
    private static final ArrayList<fieldBaseInterface> fieldBases = new ArrayList<>();


    static homeBase getInstance() {
        if (instance == null) {
            System.out.println("Creating New Home Base");
            instance = new homeBase();
            key = 0; // default key
        }
        return instance;
    }


    public static int getKey() {
        return key;
    }
    static void setKey(int key){homeBase.key = key;}


    public static void addFieldBase(fieldBaseInterface field) {fieldBases.add(field);} // subscribe
    public static void removeFieldBase(fieldBaseInterface field) {fieldBases.remove(field);} // unsubscribe
    public int getFieldBases() {return fieldBases.size();}



    // send a message to either a specific field base or a specific spy using the generic type <T>
    public void sendMessage(T target, String message) throws Exception {
        // send message to a specific instance of a field base
        if (target instanceof fieldBaseInterface){
            System.out.println("Sending message to field base");
            ((fieldBaseInterface) target).recieveMessage(encrypt(message, key));
        }
        // send message to a specific instance of a spy
        else if (target instanceof spyInterface){
            System.out.println("Sending message to spy");
            ((spyInterface) target).recieveMessage(encrypt(message, key));
        }
        else{
            throw new Exception("Invalid target");
        }
    }

    public void recieveMessage(String message) {
        System.out.println("Recieved message: " + decrypt(message, key));
    }



}