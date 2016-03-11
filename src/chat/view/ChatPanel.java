package chat.view;

import javax.swing.*;
//imports
import chat.controller.ChatController;
//pulls controller info
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextField typingField;
	private JLabel promptLabel;
	private JTextArea chatArea;
	private JCheckBox check;
	private JScrollPane textPane;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton submitButton;
	private JButton quitButton;
	private JButton analyseButton;
	
	
	
	//declare components
	public ChatPanel(ChatController baseController)
	{
	
		
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Say");
		firstTextField = new JTextField("words can be type here", 20);
		chatArea = new JTextArea(10,30);
		promptLabel = new JLabel("Chat with me");
		typingField = new JTextField("asda");
		check = new JCheckBox("Orange", false);
		quitButton = new JButton("Quit");
		tweetButton = new JButton("Tweet");
		saveButton = new JButton("Save");
		analyseButton = new JButton("analyse");
		loadButton = new JButton("load");
		
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	//after the declarations are finished the setup starts
	}	
		
	private void setupChatPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane = new JScrollPane(chatArea);
		
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	private void setupPanel()
		{
			this.setLayout(baseLayout);
			this.setBackground(Color.MAGENTA);
			this.add(firstTextField);
			//this.add(chatArea);  DO NOT HAVE
			this.add(submitButton);
			this.add(quitButton);
			this.add(tweetButton);
			this.add(saveButton);
			this.add(loadButton);
			this.add(textPane);
			this.add(analyseButton);
			this.add(check);
			this.add(promptLabel);
			typingField.setToolTipText("Type here for the chatbot");
			chatArea.setEnabled(false);
			this.setPreferredSize(new Dimension(500, 500));
			
			
		}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 143, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, 181, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 450, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 5, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, promptLabel, -6, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, check, 2, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, check, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, 0, SpringLayout.EAST, check);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 4, SpringLayout.SOUTH, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, quitButton, 8, SpringLayout.SOUTH, textPane);
		baseLayout.putConstraint(SpringLayout.WEST, quitButton, 10, SpringLayout.WEST, textPane);
		
	}
		
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = firstTextField.getText(); //grab user typed answer
				chatArea.append("\nUser: " + userText); //display info
				firstTextField.setText(""); //send text to chatBot
				String response = baseController.userToChatBot(userText); //chat will process
				chatArea.append("\nChatBot: " + response); //display the response
			}
		});
		//sets background to orange when the box is checked
		check.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(check.isSelected())
				{
					setBackground(Color.ORANGE);
				}
				else
				{
					setBackground(Color.MAGENTA);
				}
			}
		});
		
		 quitButton.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent click)
			 {
				 shutDown();
			 }
		 });
		 
		 tweetButton.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent event)
				{
				 	baseController.sendTweet("no text to send");
				}
		 });
				 
		 analyseButton.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent event)
				{
				 	String user = typingField.getText();
				 	String results = baseController.analyse(user);
				 	chatArea.setText(results);
				}
		 });
		 
		 this.addMouseListener(new MouseListener()
		 {
			 public void mouseClicked(MouseEvent click)
			 {
				 // EmptyListener
			 }
			 
			 @Override
			 public void mousePressed(MouseEvent click)
			 {
				 //empty placeholder
			 }

			 @Override
			 public void mouseReleased(MouseEvent click)
			 {
				 //empty placeholder
			 }
			 
			 @Override
			 public void mouseEntered(MouseEvent click)
			 {
				 //empty placeholder
			 }
			 
			 @Override
			 public void mouseExited(MouseEvent click)
			 {
				 //empty placeholder
			 }
		 });
		 
		
	}
	
	protected void shutDown()
	{
		JOptionPane.showMessageDialog(null, "I sorry Dave, I'm, afraid I can't Do that");
		System.exit(0);
	}
	
	public JTextField getTextField()
	{
		return typingField;
	}
	
}
	
