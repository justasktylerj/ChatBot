package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * 
 * @author tjar2074
 * V: 3.0
 * 11/5/15
 */

public class ChatView 
{
	
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Hello from your frieldly chatbot!";
		chatIcon = new ImageIcon(getClass().getResource("images/codyHead.png"));
	}
	public void displayText(String displayText)
    {
   	 JOptionPane.showMessageDialog(null, displayText);
    }

	public String collectUserText(String displayText)
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here :)").toString();
		 
		return userInput;
	}
	

}
