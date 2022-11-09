public interface spyInterface<T> {
    void die();
    void register();
    void recieveMessage(String message);
    void sendMessage(T target, String message) throws Exception;
}
