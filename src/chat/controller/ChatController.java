package chat.controller;

import chat.view.ChatView;
import chat.model.ChatBot;

/**
 * 
 * @author tjar2074
 *@version 1.1 10/21/15 added a reference to display and got an error
 */
public class ChatController 
{
	private ChatView display;
	private ChatBot myBot;
	
	public ChatController()
	{
		display = new ChatView(); 
		String userName = display.collectUserText("What is our name?");
		myBot = new ChatBot(userName);
	}
	
	public void start()
	{
		display.displayText("Hello " + myBot.getUserName());
		chat();
		
		
	}

	private void chat()
	{
		String conversation = display.collectUserText("what would you like to talk about today");
		while(myBot.lengthChecker(conversation))
		{
			if(myBot.contentChecker(conversation))
			{
				{
	               display.displayText("wow i had no idea you were interestes in");
		        }
			    conversation = display.collectUserText(conversation);
			}
		}
	}
	
	private void ShutDown()
	{
		
	}

}
