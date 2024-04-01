/**
 * NotFacebook ServerInterface
 *
 * This program is the interface
 * for the server class.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */
public interface ServerInterface {
    public void startServer();
    public void deleteMessage(int messageID, String sender, String recipient);
}
