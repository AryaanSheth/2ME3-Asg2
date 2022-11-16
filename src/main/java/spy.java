public class spy<T> extends bitshift implements spyInterface{
    boolean state;
    fieldBase base;
    int key;


    // constructor
    spy(fieldBase base){
        state = true;
        this.base = base;
        getKey();
        register();
    }


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
        if (state){
            base.addSpy(this);
        }else{
            System.out.println("Cannot register dead spy");
        }
    }



    @Override
    public void sendMessage(Object target, String message) throws Exception {
        getKey(); // update key
        // send message to a specific instance of a field base
        if (target instanceof homeBase){
            System.out.println("Sending message to Home Base");
            ((homeBase) target).recieveMessage(encrypt(message, key));
        }
        // send message to a specific instance of a spy
        else if (target instanceof fieldBaseInterface<?>){
            System.out.println("Sending message to spy");
            ((fieldBaseInterface) target).recieveMessage(encrypt(message, key));
        }
        else{
            throw new Exception("Invalid target");
        }
    }

    @Override
    public void recieveMessage(String message) {
        getKey(); // update key
        System.out.println("Recieved message: " + decrypt(message, key));
    }

}
