// fieldBase interface
public interface fieldBaseInterface<T> {
    void goDark();
    void goLive();
    int getNumSpies();
    void recieveMessage(String message);
    void sendMessage(T target, String message) throws Exception;
}