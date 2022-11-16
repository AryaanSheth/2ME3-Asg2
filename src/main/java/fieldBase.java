import java.util.ArrayList;

public class fieldBase<T> extends bitshift implements fieldBaseInterface{
    int key;
    private final ArrayList<spyInterface> spy = new ArrayList<>();



    //constructor
    fieldBase(){
        homeBase.getInstance().addFieldBase(this);
        getKey();
    }



    public int getKey() {
        key = homeBase.getInstance().getKey();
        return key;
    }



    @Override
    public void goDark() {
        System.out.println("Going dark");
        // remove from homeBase arrayList
        homeBase.getInstance().removeFieldBase(this);
    }
    @Override
    public void goLive() {
        System.out.println("Going live");
        // add to homeBase arrayList
        homeBase.getInstance().addFieldBase(this);
    }



    @Override
    public void recieveMessage(String message) {
        getKey(); // update key
        System.out.println("Recieved message: " + decrypt(message, key));
    }

    @Override
    public void sendMessage(Object target, String message) throws Exception{
        // send message to a specific instance of a field base
        getKey(); // update key
        if (target instanceof homeBase){
            System.out.println("Sending message to Home Base");
            ((homeBase<?>) target).recieveMessage(encrypt(message, key));
        }
        // send message to a specific instance of a spy
        else if (target instanceof spyInterface){
            System.out.println("Sending message to spy");
            ((spyInterface<?>) target).recieveMessage(encrypt(message, key));
        }
        else{
            throw new Exception("Invalid target");
        }
    }



    // all spies registered with this field base
    public void addSpy(spyInterface spy) {this.spy.add(spy);}
    public void removeSpy(spyInterface spy) {this.spy.remove(spy);}
    public int getNumSpies() {return spy.size();}


}

