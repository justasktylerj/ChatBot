package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter 
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		wordsList = new ArrayList<String>();
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
	
	public String topResults(List<String> wordsList)
	{
		
	}
	
	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordsList.size(); spot++)
		{
			if (wordsList.get(spot).equals(""));
			{
				wordsList.remove(spot);
				spot--;
			}
		}
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
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}

	private String[] importWordsToArray()
	{
		
	}
	
	private void removeTwitterNamesFromList(List<String> wordList)
	{
		
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>- ";
		
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++);
		{
			if (punctuation.indexOf(currentString.chartAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}

	public String sampleInvestigation()
	{
		
	}
}

