package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * 
 * @author Tyler Jarrard
 *
 * @version 1.2 10/23/15 completed the lengthChecker method. fixed the constructor and getter for userName
 */
public class ChatBot 
{
		private ArrayList<String> memesList;
		private ArrayList<String> politicalTopicList;
		private ArrayList<String> secretList;
		private String userName;
		private String content;
		
		/**
		 * 
		 * Creates an instance of the Chatbot with the supplied username.
		 * 
		 * @param userName The username for the chatbot.
		 */
		public ChatBot(String userName)
		{
			this.memesList = new ArrayList<String>();
			this.politicalTopicList = new ArrayList<String>();
			this.secretList = new ArrayList<String>();
			this.userName = userName;
			this.content = "memes";
			
			buildMemesList();
			buildPoliticalTopicsList();
			buildSecretList();
		}
		
		private void buildMemesList()
		{
			this.memesList.add("cute animals");
			this.memesList.add("doge");
			this.memesList.add("aliens");
			this.memesList.add("spoderman");
			this.memesList.add("me gusta");
			this.memesList.add("troll");
			this.memesList.add("bad luck brain");
			this.memesList.add("unhelpful high school teacher");
			this.memesList.add("what if I told you");
			this.memesList.add("aliens");
		}
		
		private void buildPoliticalTopicsList()
		{
			this.politicalTopicList.add("republican");
			this.politicalTopicList.add("democrat");
			this.politicalTopicList.add("trump");
			this.politicalTopicList.add("clinton");
			this.politicalTopicList.add("election");
			this.politicalTopicList.add("liberal");
			this.politicalTopicList.add("conservative");
			this.politicalTopicList.add("carson");
			this.politicalTopicList.add("election");
			this.politicalTopicList.add("Biden");
			this.politicalTopicList.add("fiorina");
			this.politicalTopicList.add("sanders");
			this.politicalTopicList.add("vote");
		}
		
		private void buildSecretList()
		{
			this.secretList.add("potato");
			this.secretList.add("missile");
			this.secretList.add("magic");
			this.secretList.add("cheese");
		}
		/**
		 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
		 * 
		 *otherwise returns true. 
		 * @param currentInput
		 * @return A true or false based on the length of the supplied String.
		 */
		public boolean lengthChecker(String currentInput)
		{
			boolean hasLength = false;
			
			if(currentInput != null)
			{
				if(currentInput.length() != 1)
				{
					hasLength = true;
				}
			}
			
			 //  
			
			if(currentInput != null && currentInput.length() > 0)
			{
				hasLength = true;
			}
			
			return hasLength;
		}
		
		/**
		 * 
		 * 
		 * 
		 * Checks if the supplied String matches the content area for this Chatbot instance.
		 * @param currentInput The supplied String to be checked.
		 * @return Whether it matches the content area.
		 */
		public boolean contentChecker(String currentInput)
		{
			boolean hasContent = false;
			
			if(currentInput.toLowerCase().contains(content.toLowerCase()))
			{
				hasContent = true;
			}
			
			return hasContent;
		}
		
		public boolean keyboardMashChecker(String currentInput)
		{
			boolean hasMash = false;
			
			if(currentInput.equals("sdf") || currentInput.equals("dfg") || currentInput.equals("cub") || currentInput.equals(",./"))
			{
				hasMash = true;
			}
			return hasMash;
		}
		
		public boolean quitChecker(String currentInput)
		{
			boolean hasQuit = false;
			
			if(currentInput.equals("quit"))
		
			{
				hasQuit = true;
			}
			return hasQuit;
		}
		public boolean politicalTopicChecker(String currentInput)
		{
            boolean hasPoliticalTopic = false;
			
			for(String politicalTopic : politicalTopicList)
			{
				if(currentInput.toLowerCase().contains(politicalTopic.toLowerCase()))
				{
					hasPoliticalTopic = true;
				}
			}		
			
			return hasPoliticalTopic;
		}
		
		public boolean secretChecker(String currentInput)
		{
            boolean hasSecret = false;
			
			for(String secret : secretList)
			{
				if(currentInput.toLowerCase().contains(secret.toLowerCase()))
				{
					hasSecret = true;
				}
			}		
			
			return hasSecret;
		}
		
		/**
		 * Checks to see that the supplied String value is in the current memesList variable.
		 * @param currentInput The supplied String to be checked.
		 * 
		 * 
		 * 
		 * @return Whether the supplied String is a recognized meme.
		 */
		public boolean memeChecker(String currentInput)
		{
			boolean hasMeme = false;
			
			for(String meme : memesList)
			{
				if(currentInput.toLowerCase().contains(meme.toLowerCase()))
				{
					hasMeme = true;
				}
			}		
			
			return hasMeme;
		}
		
		public String processConversation(String currentInput)
		{
			String nextConversation = "oh, what else would you like to talk about?";
			int randomTopic = (int) (Math.random() * 6); //Generates random number between 0-5
			
			if(keyboardMashChecker(currentInput))
			{
				return "stop mashing";
			}
			
			switch (randomTopic) //a way of choosing different options
			{
			    case 0:
			    	if(memeChecker(currentInput))
			    	{
			    		nextConversation = "that is a very popular meme this year.";
			    	}
				    break;
			    case 1:
			    	if(politicalTopicChecker(currentInput))
			    	{
			    		nextConversation = "I hate politics";
			    	}
			    	break;
			    case 2:
			    	if(contentChecker(currentInput))
			    	{
			    		nextConversation = "I am also interested in " + content;
			    	}
			        break;
			    case 3:
			    	if(currentInput.length() > 20)
			    	{
			    		nextConversation = "Too many words! Slow down!";
			    	}
		            break;
			    case 4:
			    	if(secretChecker(currentInput))
			    	{
			    		nextConversation = "Your Missiles hit the orc, roll 1d4+1 force damage";
			    	}
			    	break;
			    case 5:
			    	nextConversation = "What do you want to talk about?";
			    	break;
		        default:
		        	nextConversation = "Stormageddon has come... prepare to be astonished!";
		        	break;
			 }
					
			return nextConversation;
		}
		/**
		 * gsfs
		 * 
		 * @return
		 */
		public String getUserName()
		{
			return userName;
		}
		
		/**
		 * 
		 * Returns the content area for this Chat bot instance.
		 * @return The content area for this Chat bot instance.
		 */
		public String getContent()
		{
			return content;
		}
		
		/**
		 *
		 * Getter method for the memesList object.
		 * @return The reference to the meme list.
		 */
		public ArrayList<String> getMemesList()
		{
			return memesList;
		}
		
		public ArrayList<String> getSecretList()
		{
			return secretList;
		}
		/**
		 * Getter method for the politicalTopicList object.
		 * @return The reference to the political topic list.
		 *
		 */
		public ArrayList<String> getPoliticalTopicList()
		{
			return politicalTopicList;
		}
		
		/**
		 * Updates the content area for this Chatbot instance.
		 *
		 * 
		 * @param content The updated value for the content area.
		 */
		public void setContent(String content)
		{
			
		}
}