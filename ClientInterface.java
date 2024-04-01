public interface ClientInterface {
    public void sendMessage(String recipient, String message);
    public void sendMessage(String message);
    public void requestDeleteMessage(int messageID, String sender, String recipient);
    public void connectToServer();
    public void logout();
    public void login(String username, String password);
}
