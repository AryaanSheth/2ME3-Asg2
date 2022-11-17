/**
 * The interface Field base interface.
 *
 * @param <T> the type parameter
 */
// fieldBase interface
public interface fieldBaseInterface<T> {
    /**
     * Go dark.
     */
    void goDark();

    /**
     * Go live.
     */
    void goLive();

    /**
     * Gets num spies.
     *
     * @return the num spies
     */
    int getNumSpies();

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