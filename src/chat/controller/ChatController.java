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
		String userName = display.collectUserText("What is your name?");
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
	               display.displayText("wow i had no idea you were interested in " + myBot.getContent());
		    }
			else if(myBot.politicalTopicChecker(conversation))
			{
				display.displayText("I hate politics...");
			}
			else if(myBot.memeChecker(conversation))
		    { 
			     display.displayText("what a lame meme...");	
		    }
			
			conversation = display.collectUserText(conversation);
		}
	}
	
	private void ShutDown()
	{
		
	}

}
