/**
 * NotFacebook ClientInterface
 *
 * This program is the interface
 * for the client class.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */
public interface ClientInterface {
    public void sendMessage(String recipient, String message);
    public void sendMessage(String message);
    public void requestDeleteMessage(int messageID, String sender, String recipient);
    public void connectToServer();
    public void logout();
    public void login(String username, String password);
}
