package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter 
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}

	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I, the great Tyler J, just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
	public String topResults(List<String> wordList)
	{
		
	}
	
	private void removeEmptyText()
	{
		
	}
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statsPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusesPage.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		
		for (Status currentStatus : statuses)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				tweetText.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
	}

	private String[] importWordsToArray()
	{
		
	}
	
	private void removeTwitterNamesFromList(List<String> wordList)
	{
		
	}

}

