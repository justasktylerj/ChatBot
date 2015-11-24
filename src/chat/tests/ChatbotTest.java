package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.model.ChatBot;

/**
 * Class designed for testing the Chatbot object with JUnit. 
 * We will be developing tests for this as a class.
 * Each additional test will be a version decimal update.
 * @author CodyH
 * @version 1.0
 */
public class ChatbotTest
{
	private ChatBot simpleBot;
	private String userName;

	@Before
	public void setUp() throws Exception
	{
		userName = "test";
		simpleBot = new ChatBot(userName);
	}

	@After
	public void tearDown() throws Exception
	{
		userName = null;
		simpleBot = null;
	}

	@Test
	public void testChatbot()
	{
		assertNotNull("The memesList is not present",simpleBot.getMemesList());
		assertNotNull("The politicalTopicsList is not present", simpleBot.getPoliticalTopicList());
		assertSame("The username is the same object", userName, simpleBot.getUserName());
	}

	@Test
	public void testLengthChecker()
	{
		assertFalse("Correct zero length check",simpleBot.lengthChecker(""));
		assertFalse("Correct null check", simpleBot.lengthChecker(null));
		assertTrue("Correct length check", simpleBot.lengthChecker("       "));
	}

	@Test
	public void testContentChecker()
	{
		String content = "some words";
		simpleBot.setContent(content);
		assertFalse("Check blank failed", simpleBot.contentChecker(" "));
		assertFalse("Check partial failed", simpleBot.contentChecker("words"));
		assertFalse("Check partial failed", simpleBot.contentChecker("some"));
		assertTrue("Check match failed", simpleBot.contentChecker(content));
		assertTrue("Check match plus failed", simpleBot.contentChecker("content " + content));
		assertTrue("Opposite check match failed", simpleBot.contentChecker(content + " other content"));
	}
	
	@Test
	public void testKeyboardMashChecker()
	{
		assertFalse("Mash incorrectly detected", simpleBot.keyboardMashChecker("S.D.F."));
		assertFalse("Mash incorrectly detected", simpleBot.keyboardMashChecker("derf"));
		assertTrue("Mash not detected", simpleBot.keyboardMashChecker("sdf"));
		assertTrue("Mash not detected", simpleBot.keyboardMashChecker("dfg"));
		assertTrue("Mash not detected", simpleBot.keyboardMashChecker("cvb"));
		assertTrue("Mash not detected", simpleBot.keyboardMashChecker(",./"));
	}

	@Test
	public void testPoliticalTopicChecker()
	{
		assertTrue("Topic check", simpleBot.getPoliticalTopicList().contains("Democrat"));
		assertTrue("Topic check", simpleBot.getPoliticalTopicList().contains("Republican"));
		assertTrue("Topic check", simpleBot.getPoliticalTopicList().contains("11/4/16"));
	}

	@Test
	public void testMemeChecker()
	{
		assertTrue("Topic check", simpleBot.getMemesList().contains("doge"));
		assertTrue("Topic check", simpleBot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testQuitChecker()
	{
		assertFalse("False positive", simpleBot.quitChecker("exit"));
		assertTrue("False negative", simpleBot.quitChecker("quit"));
	}
	
	@Test
	public void testBuildMemesList()
	{
		assertTrue("Size check", simpleBot.getMemesList().size() >= 10);
		assertTrue("Topic check", simpleBot.getMemesList().contains("doge"));
		assertTrue("Topic check", simpleBot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testBuildPoliticalTopicList()
	{
		assertTrue("Size check", simpleBot.getPoliticalTopicList().size() >= 10);
		assertTrue("Topic check", simpleBot.getPoliticalTopicList().contains("Democrat"));
		assertTrue("Topic check", simpleBot.getPoliticalTopicList().contains("Republican"));
		assertTrue("Topic check", simpleBot.getPoliticalTopicList().contains("11/4/16"));
	}

	@Test
	public void testGetUserName()
	{
		assertSame("Getters work", userName, simpleBot.getUserName());
	}

	@Test
	public void testGetContent()
	{
		String content = "topic area of interest";
		simpleBot.setContent(content);
		assertSame("Setters and Getters work", content, simpleBot.getContent());
	}

	@Test
	public void testGetMemesList()
	{
		assertNotNull("Getters work again", simpleBot.getMemesList());
	}

	@Test
	public void testGetPoliticalTopicList()
	{
		assertNotNull("Getters still work in Java", simpleBot.getPoliticalTopicList());
	}
	
	@Test
	public void testSetContent()
	{
		String oldContent = simpleBot.getContent();
		String content = "some other content";
		simpleBot.setContent(content);
		assertNotSame("Changed values", oldContent, simpleBot.getContent());
		assertSame("Setters work", content, simpleBot.getContent());
	}

}
