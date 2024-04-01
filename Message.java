/**
 * NotFacebook Message
 *
 * This program takes in a string
 * and creates a message with a
 * messageID number that can be
 * used to identify the message.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */
public class Message {
    private String message;
    private int messageID;
    public Message(String message) {
        this.message = message;
        this.messageID = -1;
    }

    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getMessageID() {
        return this.messageID;
    }
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
    
}
