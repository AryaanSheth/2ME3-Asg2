/**
 * The interface Spy interface.
 *
 * @param <T> the type parameter
 */
public interface spyInterface<T> {
    /**
     * Die.
     */
    void die();

    /**
     * Register.
     */
    void register();

    /**
     * Recieve message.
     *
     * @param message the message
     */
    void recieveMessage(String message);

    /**
     * Send message.
     *
     * @param target  the target
     * @param message the message
     * @throws Exception the exception
     */
    void sendMessage(T target, String message) throws Exception;
}
