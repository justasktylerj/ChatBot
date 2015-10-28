package chat.view;

import javax.swing.JOptionPane;

public class ChatView 
{
	
	public void displayText(String displayText)
    {
   	 JOptionPane.showMessageDialog(null, displayText);
    }

	public String collectUserText(String displayText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, displayText);
		 
		return returnedText;
	}
	
	

}
