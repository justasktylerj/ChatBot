package chat.controller;

import chat.view.ChatView;
import chat.model.ChatBot;
import chat.view.ChatFrame;
import chat.view.ChatPanel;

/**
 * 
 * @author tjar2074
 *@version 1.1 10/21/15 added a reference to display and got an error
 */
public class ChatController 
{
	private ChatView display;
	private ChatBot myBot;
	private ChatFrame baseFrame;
	
	
	public ChatController()
	{
		display = new ChatView(); 
		String userName = display.collectUserText("What is your name?");
		myBot = new ChatBot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.displayText("Hello " + myBot.getUserName());
		chat();
	} 
//how?
	private void chat()
	{
		String conversation = display.collectUserText("what would you like to talk about today");
		//while(myBot.lengthChecker(conversation))
		//{
		//	conversation = myBot.processConversation(conversation);
		//	conversation = display.collectUserText(conversation);
		//}
	}
	
	public String userToChatBot(String conversation)
	{
		String response = "";
		if(myBot.quitChecker(conversation))
		{
			shutDown();
		}
		response = myBot.processConversation(conversation);
		
		return response;
	}
	private void shutDown()
	{
		display.displayText("I'm sorry " + myBot.getUserName() + ", I'm afriad I can't do that ");
		System.exit(0);
	}

	public ChatBot getChatBot()
	{
		return myBot;
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}
